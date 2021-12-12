package main;

import org.xml.sax.SAXException;
import parse.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = scanner.nextLine();
        System.out.println("Enter schema name");
        String schemaName = scanner.nextLine();
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new KnifeErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
        }
        System.out.println("Enter parser type");
        String parserType = scanner.nextLine();
        AbstractKnifesBuilder builder = KnifeBuilderFactory.createKnifeBuilder(parserType);
        builder.buildListKnifes(fileName);
        System.out.println(builder.getKnifes());
    }
}