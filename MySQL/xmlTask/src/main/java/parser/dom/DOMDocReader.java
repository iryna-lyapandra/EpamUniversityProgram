package parser.dom;
import model.Candy;
import model.Ingredient;
import model.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
    public ArrayList<Candy> readDoc(Document doc){
        doc.getDocumentElement().normalize();
        ArrayList<Candy> candies = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("candy");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Candy candy = new Candy();
            Value value;
            ArrayList<Ingredient> ingredients;
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                candy.setName(element.getElementsByTagName("name").item(0).getTextContent());
                candy.setEnergy(Integer.valueOf(element.getAttribute("energy")));
                candy.setType(element.getElementsByTagName("type").item(0).getTextContent());
                candy.setProduction(element.getElementsByTagName("production").item(0).getTextContent());

                ingredients = getIngredients(element.getElementsByTagName("ingredients"));
                value = getValue(element.getElementsByTagName("value"));

                candy.setIngredients(ingredients);
                candy.setValue(value);

                candies.add(candy);
            }
        }
        return candies;
    }

    private ArrayList<Ingredient> getIngredients(NodeList nodes){
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        if(nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    ingredients.add(new Ingredient(el.getTextContent()));
                }
            }
        }

        return ingredients;
    }

    private Value getValue(NodeList nodes){
        Value value = new Value();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nodes.item(0);
            value.setProtein(Double.parseDouble(element.getElementsByTagName("protein").item(0).getTextContent()));
            value.setFat(Double.parseDouble(element.getElementsByTagName("fat").item(0).getTextContent()));
            value.setCarbs(Double.parseDouble(element.getElementsByTagName("carbs").item(0).getTextContent()));
        }

        return value;
    }
}
