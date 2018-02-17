package lesson7;

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
