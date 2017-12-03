package com.adventOfCode.annieq.day3;

import java.util.HashMap;
import java.util.Map;

public class Part2 {
    
    private static class Coords {
        public int x;
        public int y;
        
        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        // puzzle input
        int input = 325489;
        int result = 0;
        int counter = 0; // how many steps to take in this circle
        Map<Coords, Integer> map = new HashMap<Coords, Integer>(); // dictionary to keep the values
        
        boolean found = false;
        
        // put the first 2 elements
        map.put(new Coords(0,0), 1);
        map.put(new Coords(1,0), 1);
        
        while (!found) {
            // move up
            ++counter;
            for (int i=1; i<=counter; ++i) {
                if (i == counter) {

                }
            }
            
            // move left
            
            // move down
            
            // move right
        }
        System.out.println(result);
    }
}
