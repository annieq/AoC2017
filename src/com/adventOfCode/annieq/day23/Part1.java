package com.adventOfCode.annieq.day23;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {
    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day22.txt");
        ArrayList<String> lines = in.getMultiLineData();
        
        // registers
        int a = 0,
            b = 0,
            c = 0,
            d = 0,
            e = 0,
            f = 0,
            g = 0,
            h = 0;
        
        // count how many mul was invoked
        int mulCounter = 0;
        
        for (String instr : lines) {
            String chunks[] = instr.split(" ");
        }
    }
}
