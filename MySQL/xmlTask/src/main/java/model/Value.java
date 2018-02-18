package model;

/**
 * Created by a on 2/18/2018.
 */
public class Value {
    private double protein;
    private double fat;
    private double carbs;

    public Value(double protein, double fat, double carbs) {
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    public Value() {
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
}
