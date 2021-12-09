package parse;

import com.classes.Knife;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class KnifeHandler extends DefaultHandler  {
    private Set<Knife> knifes;
    private Knife current;
    private KnifeXmlTag currentXmlTag;
    private EnumSet<KnifeXmlTag> withText;
    private static final String ELEMENT_KNIFE = "Knife";
    public KnifeHandler() {
        knifes = new HashSet<Knife>();
        withText = EnumSet.range(KnifeXmlTag.TYPE, KnifeXmlTag.VALUE);
    }
    public Set<Knife> getKnifes() {
        return knifes;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_KNIFE.equals(qName)) {
            current = new Knife();
            current.setId(attrs.getValue(0));
        } else {
            KnifeXmlTag temp = KnifeXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_KNIFE.equals(qName)) {
            knifes.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case TYPE -> current.setType(data);
                case HANDY -> current.setHandy(data);
                case ORIGIN -> current.setOrigin(data);
                case LENGTH -> current.getVisual().setLength(Float.parseFloat(data));
                case WIDTH -> current.getVisual().setWidth(Float.parseFloat(data));
                case MATERIAL -> current.getVisual().setMaterial(data);
                case HANDLE -> current.getVisual().setHandle(data);
                case WOODTYPE -> current.getVisual().setWoodType(data);
                case BLOODSTREAM -> current.getVisual().setBloodstream(Boolean.parseBoolean(data));
                case VALUE -> current.setValue(Boolean.parseBoolean(data));
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
