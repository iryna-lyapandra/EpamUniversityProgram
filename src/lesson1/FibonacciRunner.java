package lesson1;

/**
 * Created by a on 12/21/2017.
 */
public class FibonacciRunner {
    public static void main(String[] args) {
        System.out.print("Printing Fibonacci Numbers using cycles: \n");
            FibonacciNumbersCycles.printFibonacciStart(10000);
        System.out.println("\nPrinting Fibonacci Numbers using recursion: ");
        FibonacciNumbersRecursion.printFibonacci(10000);
    }
}
