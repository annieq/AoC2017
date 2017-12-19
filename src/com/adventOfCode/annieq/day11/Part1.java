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
        if (ns >= nwse && ns >= nesw) {
            
        }
    }
}
