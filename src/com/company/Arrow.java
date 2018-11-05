package com.company;

import java.util.TimerTask;

public class Arrow extends TimerTask {
    //    private final char left = '\u21e6';
//    private final char down = '\u21e7';
//    private final char up = '\u21e9';
//    private final char right = '\u21e8';
    private int x;
    private int y;
    private char arrow;
    private int previousX;
    private int previousY;

    public Arrow(int x, int y, char arrow) {
        this.x = x;
        this.y = y;
        this.arrow = arrow;
    }
    public void run() {
    }

    public char getArrow() {
        return arrow;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveDown(){
        previousX = x;
        previousY = y;
        y++;
    }


    public void fall() { //Speed of the arrow falling down
        previousX = getX();
        previousY = getY();
        for (y = 0; y <= 30; y++){
            moveDown();
        }


//    private boolean isItHit(){//did you miss or hit the arrow at the right time
//        return false;
//    }


    }
}
