package com.adventOfCode.annieq.day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {
	public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day7.txt");
        ArrayList<String> lines = in.getMultiLineData();
        
        ArrayList<String> prgNames = new ArrayList<String>();
        ArrayList<String> childNames = new ArrayList<String>();
        
        for (String line : lines) {
        	String prgName = line.split(" ", 2)[0];
        	prgNames.add(prgName);
        	
        	try {
        		String childName = line.split("-> ")[1];
        		childNames.add(childName);
           	} catch (ArrayIndexOutOfBoundsException e) {
           		
           	}
        }
        
        boolean found = false;
        for (String prgName : prgNames) {
        	// check if is sb's child
        	for (String childName : childNames) {
        		List<String> names = Arrays.asList(childName.split(", "));
        		if (names.contains(prgName)) {
        			System.out.println(prgName);
        			found = true;
        			break;
        		}
        	}
        	if (found)
        		break;
        }
	}
}
