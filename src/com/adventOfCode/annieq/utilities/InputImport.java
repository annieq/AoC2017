package com.adventOfCode.annieq.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class InputImport {
	BufferedReader br;
	
	public InputImport(String filename) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(filename));
	}

	/**
	 * return list of strings from single line, split into chunks
	 * @param delimiter
	 * @return
	 * @throws IOException
	 */
	public List<String> getSingleLineData(String delimiter) throws IOException {
		List<String> result = new ArrayList<String>();
		String line = br.readLine();
		result = (List<String>) Arrays.asList(line.split(delimiter));
		
		return result;
	}
	
	/**
	 * returns first line from the file. No splitting.
	 * @return
	 * @throws IOException
	 */
	public String getSingleLineData() throws IOException {
	    return br.readLine();
	}
	
	/**
	 * returns list of strings. Each line becomes single item in the list
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> getMultiLineData() throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		String line = br.readLine();
		while (line != null) {
			result.add(line);
			line = br.readLine();
		}
		
		return result;
	}
}
