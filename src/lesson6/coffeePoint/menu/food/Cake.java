package lesson6.coffeePoint.menu.food;

/**
 * Created by a on 1/21/2018.
 */
public class Cake implements Food{
    static final String NAME = "cake";
    static final double PRICE = 25;
    public static String getNAME() {
        return NAME;
    }

    public double getPRICE() {
        return PRICE;
    }
}
