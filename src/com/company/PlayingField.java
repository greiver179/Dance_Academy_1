package com.company;

import java.io.IOException;

public class PlayingField { // Everythin esthetic, seperator, lines etc

    public void drawField() throws IOException {
        drawSeperators(20);
        drawSeperators(26);
        drawSeperators(32);
        drawSeperators(38);
        drawSeperators(44);

    }

    public void drawSeperators(int column) throws IOException {
        for (int i = 0; i < 30; i++) {
            Main.terminal.setCursorPosition(column, i); // go to position(column, row)
            Main.terminal.putCharacter('\u2021');

        }
    }


    public void drawScore() {

    }
}
