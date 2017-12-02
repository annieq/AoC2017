package com.adventOfCode.annieq.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day2.txt");
        ArrayList<String> lines = in.getMultiLineData();

        int checksum = 0;
        for (String line : lines) {
            List<String> strValues = Arrays.asList(line.split("\\t"));
            ArrayList<Integer> values = (ArrayList<Integer>) strValues.stream().map(Integer::parseInt).collect(Collectors.toList());
            
            // get the numbers that evenly divide
            for (int v1 : values) {
                for (int v2 : values) {
                    if (v1 > v2 && v1 % v2 == 0)
                        checksum += v1 / v2;
                }
            }
        }
        System.out.println(checksum);
    }

}
