package com.adventOfCode.annieq.day10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {

        InputImport in = new InputImport("data//day10.txt");
        String data = in.getSingleLineData();
        
        int[] lengths = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
        Integer[] numbersList = new Integer[256];
        // initialize list
        for (int i = 0; i < numbersList.length; ++i) {
            numbersList[i] = i;
        }
        int currPos = 0;
        int skipSize = 0;
        
        for (int len : lengths) {
            // Reverse the order of that length of elements in the list, starting with the element at the current position.
            Integer[] toReverse;
            if (currPos+len < numbersList.length) {
                toReverse = Arrays.copyOfRange(numbersList, currPos, (currPos+len) % numbersList.length);
            }
            else
            {
                // need to wrap
                toReverse = new Integer[len];
                System.arraycopy(numbersList, currPos, toReverse, 0, numbersList.length - currPos);
                System.arraycopy(numbersList, 0, toReverse, numbersList.length - currPos, len - (numbersList.length - currPos));                        
            }
            Collections.reverse(Arrays.asList(toReverse));
            // update the values
            for (int i = 0; i < len; ++i) {
                numbersList[(currPos+i) % numbersList.length] = toReverse[i];
            }
            // Move the current position forward by that length plus the skip size.
            currPos = (currPos + len + skipSize) % numbersList.length;
            // Increase the skip size by one.
            ++skipSize;
        }
        // What is the result of multiplying the first two numbers in the list?
        System.out.println(numbersList[0] * numbersList[1]);
    }
}
