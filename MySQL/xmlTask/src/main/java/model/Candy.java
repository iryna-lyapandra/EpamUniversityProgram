package model;

import java.util.ArrayList;

/**
 * Created by a on 2/18/2018.
 */
public class Candy {
    private String name;
    private int energy;
    private String type;
    private ArrayList <Ingredient> ingredients = new ArrayList<Ingredient>();
    private Value value;
    private String production;

    public Candy(String name, int energy, String type, ArrayList<Ingredient> ingredients, Value value, String production) {
        this.name = name;
        this.energy = energy;
        this.type = type;
        this.ingredients = ingredients;
        this.value = value;
        this.production = production;
    }

    public Candy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
