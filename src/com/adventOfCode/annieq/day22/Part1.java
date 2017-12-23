package com.adventOfCode.annieq.day22;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day22.txt");
        ArrayList<String> data = in.getMultiLineData();
        
        // current direction
        Direction dir = Direction.UP;
        
        // length of the row
        int rowLength = data.get(0).length();
        
        // current position [x, y] -- starting in the middle of data
        int[] position = {rowLength / 2, data.size() / 2};
        
        int infectedCount = 0;
        
        for (int k = 0; k < 10000; ++k) {
            // turn left or right
            if (isInfected(getCharAt(data, position))) {
                dir = dir.turnRight();
            } else {
                dir = dir.turnLeft();
            }
            
            // infect or clean
            if (isInfected(getCharAt(data, position))) {
                clean(data, position);
            } else {
                infect(data, position);
                ++infectedCount;
            }
            
            // move
            switch (dir) {
            case UP:
                if (position[1] == 0) {
                    // add new line with clear nodes at the beginning
                    data.add(0, new String(new char[rowLength]).replace("\0", "."));
                } else {
                    --position[1];
                }
                break;
            case DOWN:
                ++position[1];
                if (position[1] == data.size()) {
                    // add new row at the end of the table
                    data.add(new String(new char[rowLength]).replace("\0", "."));
                }
                break;
            case LEFT:
                if (position[0] == 0) {
                    // add new column at the beginning
                    for (int i = 0; i < data.size(); ++i) {
                        data.set(i, "." + data.get(i));
                    }
                    ++rowLength;
                } else {
                    --position[0];
                }
                break;
            case RIGHT:
                ++position[0];
                if (position[0] == rowLength) {
                    // add new column at the end
                    for (int i = 0; i < data.size(); ++i) {
                        data.set(i, data.get(i) + ".");
                    }
                    ++rowLength;
                }
                break;
            }
        }        
        
        System.out.println(infectedCount);
    }
    
    private static boolean isInfected(char node) {
        return (node == '#');
    }
    
    private static char getCharAt(ArrayList<String> data, int[] pos) {
        return data.get(pos[1]).charAt(pos[0]);
    }
    
    private static void infect(ArrayList<String> data, int[] pos) {
        StringBuilder sb = new StringBuilder(data.get(pos[1]));
        sb.setCharAt(pos[0], '#');
        data.set(pos[1], sb.toString());
    }
    
    private static void clean(ArrayList<String> data, int[] pos) {
        StringBuilder sb = new StringBuilder(data.get(pos[1]));
        sb.setCharAt(pos[0], '.');
        data.set(pos[1], sb.toString());
    }
}
