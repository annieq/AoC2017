package com.adventOfCode.annieq.day16;

import java.io.IOException;
import java.util.Arrays;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day16.txt");
        String[] moves = in.getSingleLineData().split(",");
        
        StringBuilder programs = new StringBuilder("abcdefghijklmnop");

        int counter = 0;

        while (counter < 1000000000) {

            for (String move : moves) {
                String moveType = move.substring(0, 1);
                switch (moveType) {
                case "s":   // spin
                    int noOfPrograms = Integer.parseInt(move.substring(1));
                    String programsToMove = programs.substring(programs.length() - noOfPrograms);
                    programs.delete(programs.length() - noOfPrograms, programs.length());
                    programs.insert(0, programsToMove);
                    break;
                case "x":   // exchange
                    int[] positions = Arrays.asList(move.substring(1).split("/")).stream().mapToInt(Integer::parseInt).toArray();
                    char tmp = programs.charAt(positions[0]);
                    programs.setCharAt(positions[0], programs.charAt(positions[1]));
                    programs.setCharAt(positions[1], tmp);
                    break;
                case "p":   // partner
                    String[] prgsToSwap = move.substring(1).split("/");
                    int idx1 = programs.indexOf(prgsToSwap[0]);
                    int idx2 = programs.indexOf(prgsToSwap[1]);
                    programs.setCharAt(idx1, prgsToSwap[1].charAt(0));
                    programs.setCharAt(idx2, prgsToSwap[0].charAt(0));
                    break;
                }
            }
        }
        System.out.println(programs.toString());
    }
}
