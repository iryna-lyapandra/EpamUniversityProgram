package lesson7;

/**
 * Created by a on 1/24/2018.
 */
public class Main {
    public static void main(String[] args) {
        Pizza myPizza = new Cheese(new BasicPizza());
        System.out.println(myPizza.getIngredients());
        System.out.println(myPizza.getPrice());
    }
}
