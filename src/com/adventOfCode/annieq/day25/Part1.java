package com.adventOfCode.annieq.day25;

import java.util.ArrayList;


public class Part1 {
	
	private enum State {
		A, B, C, D, E, F
	}
	
	private static final int numberOfSteps = 12302209;
	
	private static int pointer = 0;
	
    public static void main(String[] args) {
    	
    	State currentState = State.A;
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	values.add(0);
    	
    	for (int i = 0; i < numberOfSteps; ++i) {
    		switch (currentState) {
    		case A:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state B.
    				currentState = State.B;
    			} else {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the left.
    				moveLeft(values);
//    			    - Continue with state D.
    				currentState = State.D;
    			}
    			break;
    		case B:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state C.   
    				currentState = State.C;
    			} else {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state F.
    				currentState = State.F;
    			}
    			break;
    		case C:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the left.
    				moveLeft(values);
//    			    - Continue with state C.
    				currentState = State.C;
    			} else {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the left.
    				moveLeft(values);
//    			    - Continue with state A.
    				currentState = State.A;
    			}
    			break;
    		case D:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the left.
    				moveLeft(values);
//    			    - Continue with state E.
    				currentState = State.E;
    			} else {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state A.
    				currentState = State.A;
    			}
    			break;
    		case E:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 1.
    				values.set(pointer, 1);
//    			    - Move one slot to the left.
    				moveLeft(values);
//    			    - Continue with state A.
    				currentState = State.A;
    			} else {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state B.
    				currentState = State.B;
    			}
    			break;
    		case F:
    			if (values.get(pointer) == 0) {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state C.
    				currentState = State.C;
    			} else {
//    			    - Write the value 0.
    				values.set(pointer, 0);
//    			    - Move one slot to the right.
    				moveRight(values);
//    			    - Continue with state E.
    				currentState = State.E;
    			}
    			break;
    		}
    	}
    	// count "1"s
    	int checksum = 0;
    	for (int val : values) {
    		if (val == 1)
    			++checksum;
    	}
    	System.out.println(checksum);
    }
    
    private static void moveLeft(ArrayList<Integer> values) {
    	if (pointer == 0) {
    		values.add(0, 0);
    	} else {
    		--pointer;
    	}
    }
    
    private static void moveRight(ArrayList<Integer> values) {
		++pointer;
		if (pointer >= values.size()) {
			values.add(0);
		}    	
    }
}
