package parse;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import main.Knife;
import main.Visual;
import java.util.Comparator;

public class KnifesDomBuilder extends AbstractKnifesBuilder {
    private ArrayList<Knife> knifes;
    private DocumentBuilder docBuilder;
    private Comparator<Knife> comparator;
    public KnifesDomBuilder() {
        knifes = new ArrayList<Knife>();
        comparator = (o1, o2) -> o1.getId().compareTo(o2.getId());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public KnifesDomBuilder(ArrayList<Knife> knifes) {
        super(knifes);
    }
    public ArrayList<Knife> getKnifes() {
        knifes.sort(comparator);
        return knifes;
    }
    @Override
    public void buildListKnifes(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList knifesList = root.getElementsByTagName("Knife");
            for (int i = 0; i < knifesList.getLength(); i++) {
                Element studentElement = (Element) knifesList.item(i);
                Knife knife = buildKnife(studentElement);
                knifes.add(knife);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Knife buildKnife(Element knifeElement) {
        Knife knife = new Knife();
        knife.setId(knifeElement.getAttribute("ID"));
        knife.setType(getElementTextContent(knifeElement, "Type"));
        knife.setHandy(getElementTextContent(knifeElement, "Handy"));
        knife.setOrigin(getElementTextContent(knifeElement, "Origin"));
        Boolean value = Boolean.parseBoolean(getElementTextContent(knifeElement, "Value"));
        knife.setValue(value);
        Visual visual = knife.getVisual();
        Element visualElement =  (Element) knifeElement.getElementsByTagName("Visual").item(0);
        visual.setMaterial(getElementTextContent(visualElement, "Material"));
        visual.setHandle(getElementTextContent(visualElement, "Handle"));
        Float length = Float.parseFloat(getElementTextContent(visualElement, "Length"));
        visual.setLength(length);
        Float width = Float.parseFloat(getElementTextContent(visualElement, "Width"));
        visual.setWidth(width);
        Boolean bloodstream = Boolean.parseBoolean(getElementTextContent(visualElement, "Bloodstream"));
        visual.setBloodstream(bloodstream);
        if (visual.getHandle().equals("wood")) {
            visual.setWoodType(getElementTextContent(visualElement, "WoodType"));
        }
        return knife;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
