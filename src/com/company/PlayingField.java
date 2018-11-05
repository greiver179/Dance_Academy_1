package com.company;

import java.io.IOException;

public class PlayingField { // Everythin esthetic, seperator, lines etc

    public void drawField()throws IOException {
     for(int i = 0; i < 30; i++) {
        Main.terminal.setCursorPosition(20, i); // go to position(column, row)
        Main.terminal.putCharacter('\u2021');

    }

}
    public void drawScore(){

    }
}
