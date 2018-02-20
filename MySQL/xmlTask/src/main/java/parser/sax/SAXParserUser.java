package parser.sax;

import model.Candy;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParserUser {
    private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    public static ArrayList<Candy> parseCandies(File xml, File xsd){
        ArrayList<Candy> candiesArrayList = new ArrayList<>();
        try {
            saxParserFactory.setSchema(SAXValidator.createSchema(xsd));
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xml, saxHandler);
            candiesArrayList = saxHandler.getCandiesArrayList();
        }catch (SAXException | ParserConfigurationException | IOException ex){
            ex.printStackTrace();
        }
        return candiesArrayList;
    }
}
