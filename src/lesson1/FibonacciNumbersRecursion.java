package lesson1;

/**
 * Created by a on 12/21/2017.
 */
public class FibonacciNumbersRecursion {
    static int n1 = 0, n2 = 1, sum = 0;

    public static void printFibonacci(int limit) {
        if (sum == 0) {
            System.out.print(n1 + " " + n2); //Printing the initial 2 elements (0 and 1)
        }
        sum = n1 + n2;
        n1 = n2;
        n2 = sum;
        System.out.print(" " + sum);
        if (sum < limit) {
            printFibonacci(limit);
        }
    }
}
