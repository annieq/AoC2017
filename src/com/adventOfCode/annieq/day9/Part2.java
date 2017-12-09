package com.adventOfCode.annieq.day9;

import java.io.IOException;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {

        InputImport in = new InputImport("data//day9.txt");
        String stream = in.getSingleLineData();
        
        
        // remove all cancelled characters
        for (int i = 0; i < stream.length()-1; ++i) {
            if (stream.charAt(i) == '!') {
                stream = stream.substring(0, i).concat(stream.substring(i+2));
                --i;
            }
        }
        
        // count garbage
        int count = 0;
        
        for (int i = 0; i < stream.length(); ++i) {
            if (stream.charAt(i) == '<') {
                // garbage starts here
                for (int j = i + 1; j < stream.length(); ++j) {
                    if (stream.charAt(j) != '>') {
                        ++count;
                    }
                    else {
                        i = j;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        
    }
}
