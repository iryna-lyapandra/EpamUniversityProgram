package lesson6.coffeePoint.menu.coffee;

/**
 * Created by a on 1/21/2018.
 */
public class SmallCoffee implements Coffee {
    static final String NAME = "Small coffee";
    static final double PRICE = 11;
    public Coffee getCoffee(){
        return this;
    }

    public static String getNAME() {
        return NAME;
    }

    public  double getPRICE() {
        return PRICE;
    }
}

