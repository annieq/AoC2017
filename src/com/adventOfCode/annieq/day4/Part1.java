package com.adventOfCode.annieq.day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day4.txt");
        ArrayList<String> lines = in.getMultiLineData();

        int counter = 0;
        
        for (String phrase : lines) {
            boolean valid = true;
        	ArrayList<String> words = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
        	ArrayList<String> words2 = new ArrayList<>();
        	for (String word : words) {
        	    if (words2.contains(word)) {
        	        valid = false;
        	    }
        	    else {
        	        words2.add(word);
        	    }
        	}
        	if (valid)
        	    ++counter;
        }
        System.out.println(counter);
	}

}
