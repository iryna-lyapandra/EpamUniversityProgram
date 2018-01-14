package lesson4.task2;

import java.util.ArrayList;

import static lesson4.task1.Runner.getStringBuilderFromUser;

/**
 * Created by a on 1/11/2018.
 */
public class Runner {
    public static void main(String[] args) {
        // Get user input
        StringBuilder input = getStringBuilderFromUser();

        // Get the indexes, which will later be used to create substrings
        ArrayList<Integer> indexesOfSubstrings = getArrayOfIndexesForSubstring(input);
        System.out.println(indexesOfSubstrings);

        // Generating the substrings that would fit into 1 line
        ArrayList<String> substrings = getSubstrings(input, indexesOfSubstrings);

        //Each loop prints out 81 symbols. If the line contains less than 81 symbol, the method
        // adds the needed number of spaces before the line
        for (String t : substrings) {
            System.out.printf("%81s %n", t);
        }
    }


    public static int determineEndIndex(StringBuilder sb, int startIndex) {
        int endIndex = 0;
        //check to avoid a runtime error, in case length of the last line is less than 80
        if (startIndex + 80 > sb.length()) {
            endIndex = sb.length();
            return endIndex;
        }

        //check to see if the line contains "enters"
        for (int m = startIndex; m < startIndex + 80; m++) {
            if (sb.charAt(m) == '\n') {
                endIndex = m;
                return endIndex;
            }
        }
        // for all the other lines (excluding the last line and lines containing enters)
        for (int j = startIndex + 80; j > startIndex; j--) {
            if (sb.charAt(j) == ' ') {
                endIndex = j;
                return endIndex;
            }
        }
        return endIndex;
    }

    // This method finds all the end indexes for substring and adds them into the resulting ArrayList of Integers
    public static ArrayList<Integer> getArrayOfIndexesForSubstring(StringBuilder sb) {
        ArrayList<Integer> result = new ArrayList();
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < sb.length()) {
            endIndex = determineEndIndex(sb, startIndex);
            result.add(endIndex);
            startIndex = endIndex + 1;
        }
        return result;
    }

    // This method generates substrings of the StringBuilder,
    // The array of indexes is used to asure that the substrings will contain less that 80 symbols.
    public static ArrayList<String> getSubstrings(StringBuilder sb, ArrayList<Integer> indexes) {
        ArrayList<String> substrings = new ArrayList<>();
        int start = 0;
        for (int index : indexes) {
            substrings.add(sb.substring(start, index));
            start = index;
        }
        return substrings;
    }
}

