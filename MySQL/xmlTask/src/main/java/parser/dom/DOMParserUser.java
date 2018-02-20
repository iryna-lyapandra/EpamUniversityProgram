package parser.dom;

import model.Candy;
import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;

public class DOMParserUser {
    public static ArrayList<Candy> getCandiesArrayList(File xml, File xsd){
        DOMDocCreator creator = new DOMDocCreator(xml);
        Document doc = creator.getDocument();

//        try {
//            DOMValidator.validate(DOMValidator.createSchema(xsd),doc);
//        }catch (IOException | SAXException ex){
//            ex.printStackTrace();
//        }

        DOMDocReader reader = new DOMDocReader();

        return reader.readDoc(doc);
    }
}
