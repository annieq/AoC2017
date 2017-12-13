package com.adventOfCode.annieq.day13;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day13.txt");
        ArrayList<String> lines = in.getMultiLineData();
        
        int severity = 0;
        
        for (String line : lines) {
            String[] chunks = line.split(": ");
            int depth = Integer.parseInt(chunks[0]);
            int range = Integer.parseInt(chunks[1]);
            
            if (depth % ((range-1)*2) == 0) {
                severity += depth*range;
            }
        }
        System.out.println(severity);
    }
}
