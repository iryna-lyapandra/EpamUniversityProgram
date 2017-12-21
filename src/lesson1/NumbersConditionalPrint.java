package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by a on 12/20/2017.
 */
public class NumbersConditionalPrint {
    int[] numbers = new int[5];

    NumbersConditionalPrint() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int number;
        System.out.println("Please type 5 numbers that contain not less than 5 digits. (Also, numbers cannot start with 0)");
        while (counter < 5) {
            number = scanner.nextInt();
            if (number >= 10000 || number <= -10000) {
                numbers[counter] = number;
                counter++;
            } else {
                System.out.println("Sorry, but your number contains less than 5 digits. Please, try again");
            }
        }
    }

    public static boolean checkIfPrime(int digit) {
        if (digit <= 0) {
            return false;
        }
        int divider = digit - 1;
        while (divider > 1) {
            if (digit % divider == 0) {
                return false;
            }
            divider--;
        }
        return true;
    }

    public void printNumbersContainingPrimeDigits() {
        System.out.println("\nThe following numbers contain prime digits:");
        int temp;
        for (int number : numbers) {
            List<Integer> digits = new ArrayList<>();
            temp = number;
            while (temp > 0) {
                digits.add(temp % 10);
                temp = temp / 10;
            }
            if (checkArrayOfDigits(digits)) {
                System.out.print(number + " ");
            }
        }
    }

    public boolean checkArrayOfDigits(List<Integer> digits) {
        for (int digit : digits) {
            if (checkIfPrime(digit)) {
                return true;
            }
        }
        return false;
    }

    public void printBubbleSort() {
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("\n\nSorted array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public void numbersDividedByPrevious() {
        System.out.println("\n\nNumbers that can be divided by the previous one:");
        int previous = 0;
        for (int number : numbers) {

            if (previous != 0 && number % previous == 0) {
                System.out.print(number + " ");
            }
            previous = number;
        }
    }
}
