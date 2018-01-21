package lesson6.coffeePoint.service;

/**
 * Created by a on 1/21/2018.
 */
public class Payment{
    public static void payWithCash(Customer customer) {
        printTotals(customer);
        double amountToPay = customer.getOrder().getBill().getGrandTotal() - customer.getBonusPoins();
        System.out.println("You've payed " + amountToPay + " with cash \n" +
                customer.getBonusPoins() + " bonus points were used");
    }
    public static void payWithCreditCard(Customer customer) {
        printTotals(customer);
        System.out.println("The total is " + customer.getOrder().getBill().getGrandTotal());
        double amountToPay = customer.getOrder().getBill().getGrandTotal() - customer.getBonusPoins();
        System.out.println("You've payed " + amountToPay + " with your credit card \n" +
                customer.getBonusPoins() + " bonus points were used");
    }
    public static void printTotals(Customer c){
        System.out.println("The total for coffee is " + c.getOrder().getBill().getCoffeeTotal());
        System.out.println("The total for additions is " + c.getOrder().getBill().getAdditionsTotal());
        System.out.println("The total for food is " + c.getOrder().getBill().getFoodTotal());
        System.out.println("The GRAND total is " + c.getOrder().getBill().getGrandTotal());
    }
}
