package com.adventOfCode.annieq.day11;

import java.io.IOException;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day11t.txt");
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
        int max = Math.max(Math.abs(ns),
                  Math.max(Math.abs(nesw), 
                           Math.abs(nwse)));
        int result = 0;
        int tmp = 0;
        if (Math.abs(ns) == max) {
            
        }
        if (ns > 0) {
            tmp = ns + nesw + nwse;
            if (tmp > result)
                result = tmp;
        } else {
            tmp = (ns - nesw - nwse);
            if (tmp > result)
                result = tmp;
        }
        if (nesw > 0) {
            tmp = nesw + ns - nwse;
            if (tmp > result)
                result = tmp;
        } else {
            tmp = (nesw - ns + nwse);
            if (tmp > result)
                result = tmp;
        }
        if (nwse > 0) {
            tmp = nwse + ns - nesw;
            if (tmp > result)
                result = tmp;
        } else {
            tmp = (nwse - ns + nesw);
            if (tmp > result)
                result = tmp;
        }
        System.out.println(result);
    }
}
