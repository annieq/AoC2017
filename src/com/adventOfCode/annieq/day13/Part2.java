package com.adventOfCode.annieq.day13;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day13.txt");
        ArrayList<String> lines = in.getMultiLineData();
        
        boolean caught = false;
        int picoseconds = 0;
        
        while (true) {
            
            caught = false;
            for (String line : lines) {
                String[] chunks = line.split(": ");
                int depth = Integer.parseInt(chunks[0]);
                int range = Integer.parseInt(chunks[1]);
                
                if ((depth+picoseconds) % ((range-1)*2) == 0) {
                    caught = true;
                    break;
                }
            }
            if (!caught)
                break;
            ++picoseconds;
        }
        System.out.println(picoseconds);
    }
}
