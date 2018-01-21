package lesson6.coffeePoint.menu.coffee;

/**
 * Created by a on 1/21/2018.
 */
public class BigCoffee implements Coffee{
    static final String NAME = "Big coffee";
    static final double PRICE = 15;
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
