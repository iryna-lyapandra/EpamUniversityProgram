package lesson4.task1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by a on 1/10/2018.
 */
public class Runner {
    public static void main(String[] args) {
        //get input from user
       StringBuilder input = getStringBuilderFromUser();
       //check if the input is valid. If yes, transform the input into array of chars
        if (input.length() < 1) {
            System.out.println("Please type something");
        } else {
            char[] inputChar = new char[input.length()];
            input.getChars(0, input.length() - 1, inputChar, 0);
            //Printing out the text without duplicate symbols
            System.out.println(deleteDuplicateSymbolsInTheRow(inputChar));
        }
    }
    public static StringBuilder getStringBuilderFromUser(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(20000000);
        System.out.println("Please type some text to proceed. Hit enter 5 times to finish typing");
        String temp = "";
        int counter = 0;
        while (counter < 5) {
            temp = scanner.nextLine();
            input.append(temp);
            if (temp.isEmpty()) {
                counter++;
            }
        }
        System.out.println("You are done typing");
        return input;
    }

    public static StringBuilder deleteDuplicateSymbolsInTheRow(char[] input) {
        StringBuilder result = new StringBuilder(20000000);
        char comparingChar = input[0];
        // Adding the first character to the resulting StringBuilder before the cycle
        result.append(comparingChar);
        // Loop through all the chars. If it doesn't equal to the previous char, add the current one to the result.
        for (char currentChar : input) {
            if ((!(currentChar == comparingChar)) || currentChar == '\n') {
                result.append(currentChar);
                comparingChar = currentChar;
            }
        }
        return result;
    }
}
