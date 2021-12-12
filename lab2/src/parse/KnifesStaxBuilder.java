package parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import main.Knife;
import main.Visual;
import java.util.Comparator;

public class KnifesStaxBuilder extends AbstractKnifesBuilder {
    private ArrayList<Knife> knifes;
    private XMLInputFactory inputFactory;
    private Comparator<Knife> comparator;
    public KnifesStaxBuilder() {
        comparator = (o1, o2) -> o1.getId().compareTo(o2.getId());
        inputFactory = XMLInputFactory.newInstance();
        knifes = new ArrayList<Knife>();
    }
    public KnifesStaxBuilder(ArrayList<Knife> knifes) {
        super(knifes);
    }
    public ArrayList<Knife> getKnifes() {
        knifes.sort(comparator);
        return knifes;
    }
    @Override
    public void buildListKnifes(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(KnifeXmlTag.KNIFE.getValue())) {
                        Knife knife = buildKnife(reader);
                        knifes.add(knife);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Knife buildKnife(XMLStreamReader reader) throws XMLStreamException {
        Knife knife = new Knife();
        knife.setId(reader.getAttributeValue(null, KnifeXmlTag.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (KnifeXmlTag.valueOf(name.toUpperCase())) {
                        case TYPE -> knife.setType(getXMLText(reader));
                        case HANDY -> knife.setHandy(getXMLText(reader));
                        case ORIGIN -> knife.setOrigin(getXMLText(reader));
                        case VALUE -> knife.setValue(Boolean.parseBoolean(getXMLText(reader)));
                        case VISUAL -> knife.setVisual(getXMLVisual(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (KnifeXmlTag.valueOf(name.toUpperCase()) == KnifeXmlTag.KNIFE) {
                        return knife;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <Knife>");
    }
    private Visual getXMLVisual(XMLStreamReader reader) throws XMLStreamException {
        Visual visual = new Visual();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (KnifeXmlTag.valueOf(name.toUpperCase())) {
                        case LENGTH:
                            visual.setLength(Float.parseFloat(getXMLText(reader)));
                            break;
                        case WIDTH:
                            visual.setWidth(Float.parseFloat(getXMLText(reader)));
                            break;
                        case HANDLE:
                            visual.setHandle(getXMLText(reader));
                            break;
                        case MATERIAL:
                            visual.setMaterial(getXMLText(reader));
                            break;
                        case WOODTYPE:
                            if(visual.getHandle().equals("wood")) visual.setWoodType(getXMLText(reader));
                            break;
                        case BLOODSTREAM:
                            visual.setBloodstream(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (KnifeXmlTag.valueOf(name.toUpperCase()) == KnifeXmlTag.VISUAL) {
                        return visual;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <Visual>");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
