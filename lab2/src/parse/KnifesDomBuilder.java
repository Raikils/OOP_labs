package parse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.classes.Knife;
import com.classes.Visual;

public class KnifesDomBuilder extends AbstractKnifesBuilder {
    private Set<Knife> knifes;
    private DocumentBuilder docBuilder;
    public KnifesDomBuilder() {
        knifes = new HashSet<Knife>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
        }
    }
    public KnifesDomBuilder(Set<Knife> knifes) {
        super(knifes);
    }
    public Set<Knife> getKnifes() {
        return knifes;
    }
    @Override
    public void buildSetKnifes(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("Knife");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Knife student = buildStudent(studentElement);
                knifes.add(student);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Knife buildStudent(Element knifeElement) {
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