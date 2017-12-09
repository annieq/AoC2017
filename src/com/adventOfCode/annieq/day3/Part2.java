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
        
        public Coords(Coords c) {
            this.x = c.x;
            this.y = c.y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || this.getClass() != obj.getClass())
                return false;
            
            Coords c = (Coords) obj;
            return (this.x == c.x && this.y == c.y);
        }
            
    }
    
    public static void main(String[] args) {
        // puzzle input
        int input = 325489;
        
        int result = 0;
        int counter = 0; // how many steps to take in this circle
        Map<Coords, Integer> map = new HashMap<Coords, Integer>(); // dictionary to keep the values
        
        boolean found = false;
        
        // put the first element
        map.put(new Coords(0,0), 1);
        
        Coords currentCoords = new Coords(0, 0);

        while (!found) {
            // move right
            ++counter;
            for (int i=1; i<=counter; ++i) {
                ++currentCoords.x;
                
                int currentValue = 0;
                for (Coords tmpCoords : map.keySet()) {
                    if (Math.abs(tmpCoords.x - currentCoords.x) <= 1
                            && Math.abs(tmpCoords.y - currentCoords.y) <= 1) {
                        currentValue += map.get(tmpCoords);
                    }
                }
                if (currentValue > input) {
                    found = true;
                    result = currentValue;
                    break;
                }
                map.put(new Coords(currentCoords), currentValue);
            }
            if (found) break;
            
            // move up
            for (int i=1; i<=counter; ++i) {
                ++currentCoords.y;
                int currentValue = 0;
                for (Coords tmpCoords : map.keySet()) {
                    if (Math.abs(tmpCoords.x - currentCoords.x) <= 1
                            && Math.abs(tmpCoords.y - currentCoords.y) <= 1) {
                        currentValue += map.get(tmpCoords);
                    }
                }
                if (currentValue > input) {
                    found = true;
                    result = currentValue;
                    break;
                }
                map.put(new Coords(currentCoords), currentValue);
            }
            if (found) break;

            // move left
            ++counter;
            for (int i=1; i<=counter; ++i) {
                --currentCoords.x;
                
                int currentValue = 0;
                for (Coords tmpCoords : map.keySet()) {
                    if (Math.abs(tmpCoords.x - currentCoords.x) <= 1
                            && Math.abs(tmpCoords.y - currentCoords.y) <= 1) {
                        currentValue += map.get(tmpCoords);
                    }
                }
                if (currentValue > input) {
                    found = true;
                    result = currentValue;
                    break;
                }
                map.put(new Coords(currentCoords), currentValue);
            }
            if (found) break;
            
            // move down
            for (int i=1; i<=counter; ++i) {
                --currentCoords.y;
                
                int currentValue = 0;
                for (Coords tmpCoords : map.keySet()) {
                    if (Math.abs(tmpCoords.x - currentCoords.x) <= 1
                            && Math.abs(tmpCoords.y - currentCoords.y) <= 1) {
                        currentValue += map.get(tmpCoords);
                    }
                }
                if (currentValue > input) {
                    found = true;
                    result = currentValue;
                    break;
                }
                map.put(new Coords(currentCoords), currentValue);
            }
            if (found) break;
            
        }
        System.out.println(result);
    }
}
