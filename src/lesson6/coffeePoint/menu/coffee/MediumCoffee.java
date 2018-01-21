package lesson6.coffeePoint.menu.coffee;

/**
 * Created by a on 1/21/2018.
 */
public class MediumCoffee implements Coffee {
    static final String NAME = "Medium coffee";
    static final double PRICE = 13.5;
    public Coffee getCoffee(){
        return this;
    }

    public static String getNAME() {
        return NAME;
    }

    public double getPRICE() {
        return PRICE;
    }
}
