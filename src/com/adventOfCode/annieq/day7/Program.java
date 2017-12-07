package com.adventOfCode.annieq.day7;

import java.util.ArrayList;

public class Program {

    public String name;
    public int weight;
    public ArrayList<String> children = new ArrayList<>();
    
    public Program(String strToParse) {
        String[] chunks = strToParse.split(" ");
        name = chunks[0];
        weight = Integer.parseInt(chunks[1].replaceAll("\\(|\\)", ""));
        if (chunks.length > 2) {
            for (int i=3; i<chunks.length; ++i) {
                children.add(chunks[i].replaceAll(",", ""));
            }
        }
    }
    
    public Program(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Program p = (Program) obj;
        
        return (this.name.equals(p.name));
    }
    
    public boolean hasChildren() {
        return !children.isEmpty();
    }
}
