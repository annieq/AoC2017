package com.adventOfCode.annieq.day7;

import java.io.IOException;
import java.util.ArrayList;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {
    
    private static ArrayList<Program> programs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day7.txt");
        ArrayList<String> lines = in.getMultiLineData();

        // get all the programs
        for (String programStr : lines) {
            Program program = new Program(programStr);
            programs.add(program);
        }
        
        // calculate weights
        // disclaimer: IT'S DIRTY AF!
        for (Program p : programs) {
            if (!p.hasChildren())   // no children = no problems :D
                continue;
            
            // calculate the weight of the first and second child
            Program refChild = programs.get(programs.indexOf(new Program(p.children.get(0), 0)));
            int refChildrenWeight = weight(refChild);
            Program refChild2 = programs.get(programs.indexOf(new Program(p.children.get(1), 0)));
            int refChildrenWeight2 = weight(refChild2);
            
            if (refChildrenWeight != refChildrenWeight2) { // something's wrong there
                for (int i=2; i<p.children.size(); ++i) {
                    Program child = programs.get(programs.indexOf(new Program(p.children.get(i), 0)));
                    if (weight(child) != refChildrenWeight) {
                        System.out.println(refChildrenWeight2 - refChildrenWeight + refChild.weight);
                        break;
                    }
                    else {
                        System.out.println(refChildrenWeight - refChildrenWeight2 + refChild2.weight);
                        break;
                    }
                }
            }
            else
            // check if other children have the same weight
            for (String childName : p.children) {
                Program child = programs.get(programs.indexOf(new Program(childName, 0)));
                if (refChildrenWeight != weight(child)) {
                    System.out.println(refChildrenWeight - weight(child) + child.weight);
                    break;
                }
            }
        }
    }

    /**
     * Calculates program's weight (recursively)
     * @param program
     * @return
     */
    private static int weight(Program program) {
        if (program.children.isEmpty())
            return program.weight;
        else {
            int totalWeight = program.weight;
            for (String prgName : program.children) {
                Program prg = programs.get(programs.indexOf(new Program(prgName, 0)));
                totalWeight += weight(prg);
            }
            return totalWeight;
        }
    }
}