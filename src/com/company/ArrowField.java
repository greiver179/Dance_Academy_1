package com.company;

import java.io.IOException;

public class ArrowField {
char arrow;
    //Left field----------------------------------------
    public void spawnLeft() throws IOException { //x coordinate is 23
        Arrow arrow = new Arrow(23,0,'T');
        Main.terminal.setCursorPosition(arrow.getX(), arrow.getX());
        Main.terminal.putCharacter(arrow.getArrow());


    }

    //down Field------------------------------------
    public void spawnDown() throws IOException { //x coordinate is 29

        Main.terminal.setCursorPosition(29, 0);
        //add arrow and movement

    }

    //up field------------------------------------------
    public void spawnUp() throws IOException { //x coordinate is 35
        Main.terminal.setCursorPosition(35, 0);
//same

    }

    //right field--------------------------------------
    public void spawnRight() throws IOException { //x coordinate is 41
        Main.terminal.setCursorPosition(41, 0);
//same

    }
}
