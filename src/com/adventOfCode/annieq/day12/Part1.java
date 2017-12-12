package com.adventOfCode.annieq.day12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {
	
	static ArrayList<String> connected = new ArrayList<String>();
	static ArrayList<String> lines = new ArrayList<String>();
	
    public static void main(String[] args) throws IOException {

        InputImport in = new InputImport("data//day12.txt");
        lines.addAll(in.getMultiLineData());
        
        putToList(getProgramName(lines.get(0)));
        System.out.println(connected.size());
    }
    
    private static void putToList(String name) {
    	
    	if (connected.contains(name))
    		return;
    	
    	connected.add(name);
    	List<String> children = getChildren(name);
    	if (!children.isEmpty()) {
    		for (String child : children) {
    			putToList(child);
    		}
    	}
    }
    
    private static String getProgramName(String line) {
    	String[] chunks = line.trim().split(" <-> ");
    	return chunks[0];
    }
    
    private static List<String> getChildren(String name) {
    	for (String line : lines) {
    		// find the right one
    		String[] chunks1 = line.split(" <-> ");
    		if (chunks1[0].equals(name)) {
    			// found!
    			String[] chunks2 = chunks1[1].split(", ");    	
    			if (chunks2.length > 0)
    				return Arrays.asList(chunks2);
    			else
    				return new ArrayList<String>();    			
    		}
    	}
		return new ArrayList<String>();      	
    }
}
