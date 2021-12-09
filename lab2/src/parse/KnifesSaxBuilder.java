package parse;

import com.classes.Knife;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class KnifesSaxBuilder extends AbstractKnifesBuilder {
    private Set<Knife> knifes;
    private KnifeHandler handler = new KnifeHandler();
    private XMLReader reader;
    public KnifesSaxBuilder() {
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
    public KnifesSaxBuilder(Set<Knife> knifes) {
        super(knifes);
    }
    public Set<Knife> getKnifes() {
        return knifes;
    }
    @Override
    public void buildSetKnifes(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        knifes = handler.getKnifes();
    }
}
