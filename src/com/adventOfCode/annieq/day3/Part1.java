package com.adventOfCode.annieq.day3;

public class Part1 {

    public static void main(String[] args) {
        // puzzle input
        int input = 325489;

        int stepsHorizontal = 0;
        int stepsVertical = 0;
        int currentVal = 1;
        int counter = 0; // how many steps to take in this circle
        boolean found = false;
        
        while (!found) {
            // move right
            ++counter;
            for (int i=1; i<=counter; ++i) {
                ++stepsHorizontal;
                ++currentVal;
                if (currentVal >= input) {
                    found = true;
                    break;
                }
            }
            if (currentVal >= input) {
                found = true;
                break;
            }
            
            // move up
            for (int i=1; i<=counter; ++i) {
                ++stepsVertical;
                ++currentVal;
                if (currentVal >= input) {
                    found = true;
                    break;
                }
            }
            if (currentVal >= input) {
                found = true;
                break;
            }
            
            // move left
            ++counter;
            for (int i=1; i<=counter; ++i) {
                --stepsHorizontal;
                ++currentVal;
                if (currentVal >= input) {
                    found = true;
                    break;
                }
            }
            if (currentVal >= input) {
                found = true;
                break;
            }
            
            // move down
            for (int i=1; i<=counter; ++i) {
                --stepsVertical;
                ++currentVal;
                if (currentVal >= input) {
                    found = true;
                    break;
                }
            }
            if (currentVal >= input) {
                found = true;
                break;
            }
        }
        System.out.println(Math.abs(stepsHorizontal) + Math.abs(stepsVertical));
    }

}
