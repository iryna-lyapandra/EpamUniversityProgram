package lesson6.coffeePoint.service;
import lesson6.coffeePoint.menu.additions.*;
import lesson6.coffeePoint.menu.coffee.*;
import lesson6.coffeePoint.menu.food.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 1/21/2018.
 */
public class Bill {
    private double coffeeTotal;
    private double additionsTotal;
    private double foodTotal;
    private double grandTotal;

    public Bill() {
        this.coffeeTotal = 0;
        this.additionsTotal = 0;
        this.foodTotal = 0;
        this.grandTotal = 0;
    }

    public double getCoffeeTotal() {
        return coffeeTotal;
    }

    public void setCoffeeTotal(List <Coffee> coffeeOrder) {
        for (Coffee coffee : coffeeOrder){
            this.coffeeTotal += coffee.getPRICE();
        }
    }

    public double getAdditionsTotal() {
        return additionsTotal;
    }

    public void setAdditionsTotal( List <Additions> additionsOrder) {
        for (Additions addition : additionsOrder){
            this.additionsTotal += addition.getPRICE();
        }
    }

    public double getFoodTotal() {
        return foodTotal;
    }

    public void setFoodTotal(List <Food> foodOrder) {
        for (Food foodItem : foodOrder){
            this.foodTotal += foodItem.getPRICE();
        }
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal() {
        grandTotal = getCoffeeTotal()+getAdditionsTotal()+getFoodTotal();
    }
    public double calculateBonusPoints(){
        return getGrandTotal()*0.02;
    }
}
