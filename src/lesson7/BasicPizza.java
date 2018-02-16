package lesson7;

/**
 * Created by a on 1/24/2018.
 */
public class BasicPizza implements Pizza{

    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public String getIngredients() {
        return "Dough";
    }
}
