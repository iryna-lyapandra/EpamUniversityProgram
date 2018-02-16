package lesson7;

/**
 * Created by a on 1/24/2018.
 */
 class PizzaDecorator implements Pizza{
     protected Pizza currentPizza;
     public PizzaDecorator(Pizza pizza){
         this.currentPizza = pizza;
     }

    @Override
    public double getPrice() {
        return currentPizza.getPrice();
    }

    @Override
    public String getIngredients() {
        return currentPizza.getIngredients();
    }
}
