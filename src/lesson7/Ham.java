package lesson7;

/**
 * Created by a on 2/17/2018.
 */
public class Ham extends PizzaDecorator{
    public Ham(Pizza pizza) {
        super(pizza);
    }
    @Override
    public double getPrice() {
        return currentPizza.getPrice() + 9;
    }

    @Override
    public String getIngredients() {
        return currentPizza.getIngredients() + ", ham";
    }
}
