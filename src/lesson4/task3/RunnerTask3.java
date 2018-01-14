package lesson4.task3;

import java.util.Scanner;

/**
 * Created by a on 1/14/2018.
 */
public class RunnerTask3 {
    public static void main(String[] args) {
        String[] rotations = generateRotations();
        System.out.println("Rotations:");
        printAnArray(rotations);
        String[] sortedRotations = sort(rotations);
        System.out.println("Sorted rotations:");
        printAnArray(sortedRotations);
        String lastLetters = takeLastLetters(sortedRotations);
        System.out.println("Last letters: " + lastLetters);
    }

    //This method prompts the user to input and word and to create an array of possible rotations based on the input.
    public static String[] generateRotations() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, type a word");
        String word = sc.next();
        String[] rotations = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            rotations[i] = word;
            word = word.substring(1, word.length()) + word.substring(0, 1);
        }
        return rotations;
    }

    //This method sorts a passed in array of rotations using bubble sort
    public static String[] sort(String[] rotations) {
        for (int i = rotations.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rotations[j].compareTo(rotations[j + 1]) > 0) {
                    String temp = rotations[j];
                    rotations[j] = rotations[j + 1];
                    rotations[j + 1] = temp;
                }
            }
        }
        return rotations;
    }

    // This method creates a String of last characters of each rotation
    public static String takeLastLetters(String[] sortedRotations) {
        String result = new String();
        for (int i = 0; i < sortedRotations.length; i++) {
            result += sortedRotations[i].charAt(sortedRotations[i].length() - 1);
        }
        return result;
    }

    public static void printAnArray(String[] rotations) {
        for (int i = 0; i < rotations.length; i++) {
            System.out.println(rotations[i]);
        }
        System.out.println();
    }
}
