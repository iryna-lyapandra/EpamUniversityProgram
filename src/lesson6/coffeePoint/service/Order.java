package lesson6.coffeePoint.service;

import lesson6.coffeePoint.menu.additions.*;
import lesson6.coffeePoint.menu.coffee.*;
import lesson6.coffeePoint.menu.food.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by a on 1/21/2018.
 */
public class Order {
    private Bill bill;
    private List <Coffee> coffeeOrder = new ArrayList();
    private List <Additions> additionsOrder= new ArrayList();
    private List <Food> foodOrder = new ArrayList();
    public void setBill (Bill billToSet){
        this.bill = billToSet;
    }
    public void scanOrder (){
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Hello! To order \nsmall coffee - press 1 \nmedium coffee - " +
                "press 2 \nbig coffee - press 3 \nIf you don't wish to order any coffee, please press any other number.\n" +
                "To order multiple cups of coffee just type numbers one by one. Once you are done typing, press any number");
        while (true) {
            number = scanner.nextInt();
            if (number >= 1 && number <= 3) {
                setCoffeeOrder(number);
            } else {
                break;
            }
        }
        if (coffeeOrder.size()>0){
            System.out.println("You can add the following additions to your coffee" +
                    "\nMilk? - press 1 \nTopping? - press 2 \nWhipped cream? - press 3\n" +
                    "When you are done selecting additions, press any other number"
            );
            while (true) {
                number = scanner.nextInt();
                if (number >= 1 && number <= 3) {
                    setAdditionsOrder(number);
                } else {
                    break;
                }
            }
        }
        System.out.println("You can add the following food to your order" +
                "\nCake? - press 1 \nHotdog? - press 2 \nSandwich? - press 3\n" +
                "When you are done selecting food, press any other number");
        while (true) {
            number = scanner.nextInt();
            if (number >= 1 && number <= 3) {
                setFoodOrder(number);
            } else {
                break;
            }
        }

    }


    public void setCoffeeOrder(int arg) {
        switch (arg) {
            case 1:
                coffeeOrder.add(new SmallCoffee());
                break;
            case 2:
                coffeeOrder.add(new MediumCoffee());
                break;
            case 3:
                coffeeOrder.add(new BigCoffee());
                break;
            default:
                throw new IllegalArgumentException("Incorrect number");
        }
    }


    public void setAdditionsOrder(int arg) {
        switch (arg) {
            case 1:
                additionsOrder.add(new Milk());
                break;
            case 2:
                additionsOrder.add(new Topping());
                break;
            case 3:
                additionsOrder.add(new WhippedCream());
                break;
            default:
                throw new IllegalArgumentException("Incorrect number");
        }
    }

    public void setFoodOrder(int arg) {
        switch (arg) {
            case 1:
                foodOrder.add(new Cake());
                break;
            case 2:
                foodOrder.add(new Hotdog());
                break;
            case 3:
                foodOrder.add(new Sandwich());
                break;
            default:
                throw new IllegalArgumentException("Incorrect number");
        }
    }

    public Bill getBill() {
        return bill;
    }


    public List<Coffee> getCoffeeOrder() {
        return coffeeOrder;
    }

    public List<Additions> getAdditionsOrder() {
        return additionsOrder;
    }

    public List<Food> getFoodOrder() {
        return foodOrder;
    }
}
