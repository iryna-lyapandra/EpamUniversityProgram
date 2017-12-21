package lesson1;

/**
 * Created by a on 12/20/2017.
 */
public class FibonacciNumbersCycles {
    static int n1 = 0;
    static int n2 = 1;

    public static void printFibonacciStart(int limit) {
        System.out.print(n1 + " " + n2);
        printFibonacci(limit);
    }

    public static void printFibonacci(int limit) {
        int sum = 0;
        while (sum < limit) {
            sum = n1 + n2;
            System.out.print(" " + sum);
            n1 = n2;
            n2 = sum;
        }
    }
}
