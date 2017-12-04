package com.adventOfCode.annieq.day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day4.txt");
        ArrayList<String> lines = in.getMultiLineData();

        int counter = 0;
        
        for (String phrase : lines) {
        	ArrayList<String> words = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
        	for (String word : words) {
        		words.remove(word); // doesn't work
        		if (words.contains(word)) {
        			++counter;
        			break;
        		}
        	}
        }
        System.out.println(counter);
	}

}
