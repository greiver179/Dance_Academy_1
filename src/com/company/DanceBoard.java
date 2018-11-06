package com.company;

import java.io.IOException;

public class DanceBoard {


    public void drawDancePad() throws IOException { //Draws dance pad
        Main.terminal.setCursorPosition(9,10);//left side
        //terminal.enableSGR();
        Main.terminal.putCharacter('\u21d0');


        Main.terminal.setCursorPosition(11,10);//Right side u21d2
        Main.terminal.putCharacter('\u21d2');

        Main.terminal.setCursorPosition(10,9);// up u21d1
        Main.terminal.putCharacter('\u21d1');
        Main.terminal.setCursorPosition(10,11);//down u21d3
        Main.terminal.putCharacter('\u21d3');

    }

 /*   public void drawArrow() throws IOException {
        Main.terminal.setCursorPosition(15,15);
        Main.terminal.putCharacter('\u21e8');
    }*/

    public void drawLightUp() throws  IOException{


    }


}
