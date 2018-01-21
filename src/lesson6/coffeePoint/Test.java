package lesson6.coffeePoint;

import lesson6.coffeePoint.service.Customer;
import lesson6.coffeePoint.service.Order;

/**
 * Created by a on 1/21/2018.
 */
public class Test {
    public static void main(String[] args) {
        Customer iryna = new Customer();
        iryna.makeAnOrder();
        iryna.getBilled();
        iryna.calculateBonusPoints();
        iryna.pay();
    }
}
