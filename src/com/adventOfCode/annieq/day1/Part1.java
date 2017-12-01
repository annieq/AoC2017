package com.adventOfCode.annieq.day1;

import java.io.IOException;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day1.txt");
        char[] input = in.getSingleLineData().toCharArray();
        int sum = 0;

        for (int i=0; i< input.length; ++i) {
            if (input[i] == input[(i+1)%input.length]) {
                sum += Integer.parseInt(Character.toString(input[i]));
            }
        }
        System.out.println(sum);
    }
}
