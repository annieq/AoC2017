package com.adventOfCode.annieq.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    static HashMap<String, Integer> registers = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day8.txt");
        ArrayList<String> lines = in.getMultiLineData();
        
        for (String line : lines) {
            String[] chunks = line.split(" ");
            String regName = chunks[0];
            String oper = chunks[1];
            int val = Integer.parseInt(chunks[2]);
            // chunks[3] is "if"
            String condRegName = chunks[4];
            String condOper = chunks[5];
            int condVal = Integer.parseInt(chunks[6]);
            
            registers.putIfAbsent(regName, 0);
            registers.putIfAbsent(condRegName, 0);
            
            if (conditionMet(condRegName, condOper, condVal)) {
                int tmpVal = registers.get(regName);
                switch (oper) {
                case "inc":
                    registers.put(regName, tmpVal + val);
                    break;
                case "dec":
                    registers.put(regName, tmpVal - val);
                    break;
                }
            }
        }
        // find the max value
        int maxValue = Integer.MIN_VALUE;
        for (int value : registers.values()) {
            if (value > maxValue)
                maxValue = value;
        }
        System.out.println(maxValue);
    }
    
    private static boolean conditionMet(String regName, String oper, int value) {

        switch (oper) {
        case ">":
            return registers.get(regName) > value;
        case ">=":
            return registers.get(regName) >= value;       
        case "<":
            return registers.get(regName) < value;
        case "<=":
            return registers.get(regName) <= value;          
        case "==":
            return registers.get(regName) == value;
        case "!=":
            return registers.get(regName) != value;     

        default:
            return false;
        }
    }
}
