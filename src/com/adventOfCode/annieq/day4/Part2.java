package com.adventOfCode.annieq.day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day4.txt");
        ArrayList<String> lines = in.getMultiLineData();

        int counter = 0;
        
        for (String phrase : lines) {
            boolean valid = true;
            ArrayList<String> words = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
            ArrayList<String> words2 = new ArrayList<>();
            for (String word : words) {
                for (String permutation : permutation(word)) {
                    if (words2.contains(permutation)) {
                        valid = false;
                    }
                }
                if (valid) {
                    words2.add(word);
                }
            }
            if (valid)
                ++counter;
        }
        System.out.println(counter);
    }
    
    /**
     * List permutation of a string
     * 
     * @param s the input string
     * @return  the list of permutation
     */
    private static ArrayList<String> permutation(String s) {
        // The result
        ArrayList<String> res = new ArrayList<String>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return     a merged new list, e.g. {"cab", "acb" ... }
     */
    private static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible postions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }

}
