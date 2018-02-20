package parser.sax;


import model.Candy;
import model.Ingredient;

import model.Value;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private ArrayList<Candy> candiesArrayList = new ArrayList<>();
    private Candy candy = null;
    private ArrayList<Ingredient> ingredients = null;
    private Value value = null;

    private boolean cName;
    private boolean cEnergy;
    private boolean cType;
    private boolean cIngredients;
    private boolean cIngredient;
    private boolean cValue;
    private boolean cProtein;
    private boolean cFat;
    private boolean cCarbs;
    private boolean cProduction;

    public ArrayList<Candy> getCandiesArrayList(){
        return this.candiesArrayList;
    }

    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")){cName = true;}
        if (qName.equalsIgnoreCase("energy")){cEnergy = true;}
        else if (qName.equalsIgnoreCase("type")){cType = true;}
        else if (qName.equalsIgnoreCase("ingredients")){cIngredients = true;}
        else if (qName.equalsIgnoreCase("ingredient")){cIngredient = true;}
        else if (qName.equalsIgnoreCase("value")){cValue = true;}
        else if (qName.equalsIgnoreCase("protein")){cProtein = true;}
        else if (qName.equalsIgnoreCase("fat")){cFat = true;}
        else if (qName.equalsIgnoreCase("carbs")){cCarbs = true;}
        else if (qName.equalsIgnoreCase("production")){cProduction = true;}
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("candy")){
            candiesArrayList.add(candy);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (cName){
            candy.setName(new String(ch, start, length));
            cName = false;
        }
        else if (cEnergy){
            candy.setEnergy(Integer.parseInt(new String(ch, start, length)));
            cEnergy = false;
        }
        else if (cType){
            candy.setType(new String(ch, start, length));
            cType = false;
        }

        else if (cIngredients){
            ingredients = new ArrayList<>();
            cIngredients = false;
        }

        else if (cIngredient){
            Ingredient ingredient = new Ingredient();
            ingredient.setName(new String(ch, start, length));
            ingredients.add(ingredient);
            candy.setIngredients(ingredients);
            cIngredient = false;
        }
        else if (cValue){
            value = new Value();
            cValue = false;
        }
        else if (cProtein){
            value.setProtein(Double.parseDouble(new String(ch, start, length)));
            cValue = false;
        }
        else if (cFat){
            value.setFat(Double.parseDouble(new String(ch, start, length)));
            cValue = false;
        }
        else if (cCarbs){
            value.setCarbs(Double.parseDouble(new String(ch, start, length)));
            candy.setValue(value);
            cValue = false;
        }
        else if (cProduction){
            candy.setProduction(new String(ch, start, length));
            cProduction = false;
        }
    }
}


