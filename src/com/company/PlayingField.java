package com.company;

import java.io.IOException;

public class PlayingField { // Everythin esthetic, seperator, lines etc

    final int lineA = 20;
    final int lineB = 26;
    final int lineC = 32;
    final int lineD = 38;
    final int lineE = 44;
    public void drawField() throws IOException {



        drawVerticalSeperator(lineA);
        drawVerticalSeperator(lineB);
        drawVerticalSeperator(lineC);
        drawVerticalSeperator(lineD);
        drawVerticalSeperator(lineE);
       // drawHorisontalSeperator(18);
        drawHitbox(23);
        drawHitbox(29);
        drawHitbox(35);
        drawHitbox(41);
        drawScore();
    }

    public void drawVerticalSeperator(int column) throws IOException {
        for (int i = 0; i < 23; i++) {
            Main.terminal.setCursorPosition(column, i); // go to position(column, row)
            Main.terminal.putCharacter('\u2021');

        }
    }

 /*   public void drawHorisontalSeperator(int row) throws IOException {
        for (int i = 20; i < 45; i++) {
            Main.terminal.setCursorPosition(i, row); // go to position(column, row)
            Main.terminal.putCharacter('\u002D');

        }
    }*/


    public void drawScore()throws IOException{

        for (int i = 11; i <= 11; i++) {

            Main.terminal.setCursorPosition(i,5);

            Main.terminal.putCharacter('\u2665');

            System.out.println(" ");

        }



    }

    public void deleteScore()throws IOException{

        for (int i = 11; i <= 11; i++) {

            Main.terminal.setCursorPosition(i,5);

            Main.terminal.putCharacter(' ');

            System.out.println(" ");

        }

    public void drawHitbox(int line) throws  IOException{
        Main.terminal.setCursorPosition(line,20);// up u21d1
        Main.terminal.putCharacter('\u21d1');

    }
}
