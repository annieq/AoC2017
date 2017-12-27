package com.adventOfCode.annieq.day11;

import java.io.IOException;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day11.txt");
        String[] moves = in.getSingleLineData().split(",");
        
        // number of steps in directions:
        int ns = 0;
        int nwse = 0;
        int nesw = 0;
        
        for (String move : moves) {
            switch (move) {
            case "n":
                ++ns;
                break;
            case "s":
                --ns;
                break;
            case "ne":
                ++nesw;
                break;
            case "nw":
                ++nwse;
                break;
            case "sw":
                --nesw;
                break;
            case "se":
                --nwse;
                break;
            }
        }
        
        int tmp = 0;
        
        if (nwse > 0 && nesw > 0) {
            tmp = Math.min(Math.abs(nwse), Math.abs(nesw));
            nwse -= tmp;
            nesw -= tmp;
            ns += tmp;
        } else if (nwse < 0 && nesw < 0) {
            tmp = Math.min(Math.abs(nwse), Math.abs(nesw));
            nwse += tmp;
            nesw += tmp;
            ns -= tmp;
        }
        
        if (ns < 0 && nesw > 0) {
            tmp = Math.min(Math.abs(ns), Math.abs(nesw));
            ns += tmp;
            nesw -= tmp;
            nwse -= tmp;
        } else if (ns > 0 && nesw < 0) {
            tmp = Math.min(Math.abs(ns), Math.abs(nesw));
            ns -= tmp;
            nesw += tmp;
            nwse += tmp;            
        }
        
        if (ns > 0 && nwse < 0) {
            tmp = Math.min(Math.abs(ns), Math.abs(nwse));
            ns -= tmp;
            nwse += tmp;
            nesw += tmp;            
        } else if (ns < 0 && nwse > 0) {
            tmp = Math.min(Math.abs(ns), Math.abs(nwse));
            ns += tmp;
            nwse -= tmp;
            nesw -= tmp;      
        }
        int result = Math.abs(ns + nwse + nesw);
        
        System.out.println(result);
    }
}
