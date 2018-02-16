package lesson7;

/**
 * Created by a on 1/24/2018.
 */
public class Cheese extends PizzaDecorator{

    public Cheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public double getPrice() {
        return currentPizza.getPrice() + 5;
    }

    @Override
    public String getIngredients() {
        return currentPizza.getIngredients() + ", cheese";
    }
}
