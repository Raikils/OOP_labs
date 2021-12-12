package parse;

import main.Knife;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class KnifesSaxBuilder extends AbstractKnifesBuilder {
    private ArrayList<Knife> knifes;
    private KnifeHandler handler = new KnifeHandler();
    private XMLReader reader;
    private Comparator<Knife> comparator;
    public KnifesSaxBuilder() {
        comparator = (o1, o2) -> o1.getId().compareTo(o2.getId());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new KnifeErrorHandler());
        reader.setContentHandler(handler);
    }
    public KnifesSaxBuilder(ArrayList<Knife> knifes) {
        super(knifes);
    }
    public ArrayList<Knife> getKnifes() {
        knifes.sort(comparator);
        return knifes;
    }
    @Override
    public void buildListKnifes(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        knifes = handler.getKnifes();
    }
}
