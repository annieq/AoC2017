package com.adventOfCode.annieq.day5;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {
    
    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day5.txt");
        ArrayList<String> lines = in.getMultiLineData();        
        int[] jumps = lines.stream().mapToInt(Integer::parseInt).toArray();
        
        int counter = 0; // number of jumps
        int pointer = 0;
        int tmp = 0; // temporary pointer
        try {
            while (true) {
                tmp = pointer;
                pointer += jumps[pointer];
                ++jumps[tmp];
                ++counter;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(counter);
        }
        
    }
    
}
