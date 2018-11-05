package com.company;

public class Arrow {
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
        fall();
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

    private void fall() { //Speed of the arrow falling down
        previousX = getX();
        previousY = getY();
        do {
            y++;
        } while (previousY < 30);


//    private boolean isItHit(){//did you miss or hit the arrow at the right time
//        return false;
//    }


    }
}
