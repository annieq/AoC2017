package com.adventOfCode.annieq.day22;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;
    
    Direction turnRight() {
        return Direction.values()[(this.ordinal()+1) % Direction.values().length];
    }
    
    Direction turnLeft() {
        int tmp = (this.ordinal()-1) % Direction.values().length;
        if (tmp < 0) {
            tmp += Direction.values().length;
        }
        return Direction.values()[tmp];
    }
}
