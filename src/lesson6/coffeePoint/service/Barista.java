package lesson6.coffeePoint.service;

/**
 * Created by a on 1/21/2018.
 */
public class Barista {

public static Order takeOrder(){
    Order order = new Order();
    order.scanOrder();
    return order;
}
public static void createABill(Order orderToBill){
    Bill bill = new Bill();
    bill.setCoffeeTotal(orderToBill.getCoffeeOrder());
    bill.setAdditionsTotal(orderToBill.getAdditionsOrder());
    bill.setFoodTotal(orderToBill.getFoodOrder());
    bill.setGrandTotal();
    orderToBill.setBill(bill);
}
public static void chargeACustomer(Customer customer){
    if (customer.paysWithCreditCard){
        Payment.payWithCreditCard(customer);
    }
    else {
        Payment.payWithCash(customer);
    }
}


}
