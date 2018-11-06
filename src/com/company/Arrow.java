package com.company;

import java.io.IOException;

import static com.company.Main.terminal;

public class Arrow {
    //    private final char left = '\u21e6';
//    private final char down = '\u21e7';
//    private final char up = '\u21e9';
//    private final char right = '\u21e8';
    private int x;
    private int y;
    public char arrow;
    private int previousX;
    private int previousY;

    public Arrow(int x, int y, char arrow) {
        this.x = x;
        this.y = y;
        this.arrow = arrow;

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

    public void fall(Arrow arrow) { //Speed of the arrow falling down
        if (arrow.getY() == 23) {
            arrow.arrow = ' ';
        }
        y++;
    }



}

