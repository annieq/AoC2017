package com.adventOfCode.annieq.day6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {

        InputImport in = new InputImport("data//day6.txt");
        List<String> bankStartValues = in.getSingleLineData("\\t");
        int[] bankValues = bankStartValues.stream().mapToInt(Integer::parseInt).toArray();

        ArrayList<int[]> history = new ArrayList<>();
        int[] tmp = bankValues.clone();
        history.add(tmp);

        int counter = 0;
        int loopSize = 0;
        boolean found = false;

        while (!found) {
            ++counter;
            
            // look for the highest
            int pos = 0;
            int max = bankValues[0];
            for (int i=0; i<bankValues.length; ++i) {
                if (bankValues[i] > max) {
                    pos = i;
                    max = bankValues[i];
                }
            }
            // redistribute
            bankValues[pos] = 0;
            for (int i=1; i<=max; ++i) {
                ++bankValues[(i+pos)%bankValues.length];
            }
            
            // check if has been seen before
            tmp = bankValues.clone();
            for (int[] historyEntry : history) {
                if (Arrays.equals(historyEntry, tmp)) {
                    found = true;
                    loopSize = counter - history.indexOf(historyEntry);
                    break;
                }
            }

            // save new distribution in history
            if (!found) {
                history.add(tmp);
            }            
        }

        System.out.println(loopSize);
    }

}
