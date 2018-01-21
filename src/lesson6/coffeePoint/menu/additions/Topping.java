package lesson6.coffeePoint.menu.additions;

/**
 * Created by a on 1/21/2018.
 */
public class Topping implements Additions{
    static final String NAME = "topping";
    static final double PRICE = 3;

    public static String getNAME() {
        return NAME;
    }

    public double getPRICE() {
        return PRICE;
    }
}

