package lesson6.coffeePoint.service;

/**
 * Created by a on 1/21/2018.
 */
public class Customer {
    private Order order;
    private double bonusPoins;
    boolean paysWithCreditCard = false;

    public Customer(double bonusPoins, boolean paysWithCreditCard) {
        this.bonusPoins = bonusPoins;
        this.paysWithCreditCard = paysWithCreditCard;
    }
    public Customer() {
    }


    public void makeAnOrder(){
        order = Barista.takeOrder();
    }
    public void getBilled(){
        Barista.createABill(order);
    }
    public void calculateBonusPoints(){
        this.bonusPoins = this.order.getBill().calculateBonusPoints();
    }
    public void pay(){
        Barista.chargeACustomer(this);
    }

    public Order getOrder() {
        return order;
    }
    public double getBonusPoins() {
        return bonusPoins;
    }
}
