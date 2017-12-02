package com.adventOfCode.annieq.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day2.txt");
        ArrayList<String> lines = in.getMultiLineData();

        int checksum = 0;
        for (String line : lines) {
            List<String> strValues = Arrays.asList(line.split("\\t"));
            ArrayList<Integer> values = (ArrayList<Integer>) strValues.stream().map(Integer::parseInt).collect(Collectors.toList());
            
            // get min and max
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int val : values) {
                if (val < min) min = val;
                if (val > max) max = val;
            }
            checksum += (max - min);
        }
        System.out.println(checksum);
    }

}
