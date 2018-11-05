package com.company;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
   public static Terminal terminal;
    public static void main(String[] args) throws IOException,InterruptedException {


        // 21D0 till  21D3


        terminal = createTerminal();
        Player player = createPlayer();

        for (int i = 0; i < 30; i++) {
            terminal.setCursorPosition(20, i); // go to position(column, row)
            terminal.putCharacter('\u2021');

        }

    /*    terminal.setCursorPosition(9,10);//left side
        //terminal.enableSGR();
        terminal.putCharacter('\u21d0');


        terminal.setCursorPosition(11,10);//Right side u21d2
        terminal.putCharacter('\u21d2');

        terminal.setCursorPosition(10,9);// up u21d1
        terminal.putCharacter('\u21d1');

        terminal.setCursorPosition(9,11);//down u21d3
        terminal.putCharacter('\u21d3');*/

        drawCharacters(terminal,player);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke);

            drawCharacters(terminal,player);


        } while (true);

    }


    private static Terminal createTerminal() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }
    private static Player createPlayer() {
        return new Player(10, 10, '\u263a');
    }


    private static void movePlayer(Player player, KeyStroke keyStroke)throws InterruptedException,IOException {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                player.moveUp();
                drawCharacters(terminal,player);
                Thread.sleep(100);
                player.moveDown();
                drawCharacters(terminal,player);
                break;
            case ArrowDown:
                player.moveDown();
                drawCharacters(terminal,player);
                Thread.sleep(100);
                player.moveUp();
                break;
            case ArrowLeft:
                player.moveLeft();
                drawCharacters(terminal,player);
                Thread.sleep(100);
                player.moveRight();
                break;
            case ArrowRight:
                player.moveRight();
                drawCharacters(terminal,player);
                Thread.sleep(100);
                player.moveLeft();
                break;
        }
    }

    private static KeyStroke getUserKeyStroke(Terminal terminal) throws InterruptedException, IOException {
        KeyStroke keyStroke;
        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);
        return keyStroke;
    }


    private static void drawCharacters(Terminal terminal, Player player) throws IOException {

        DanceBoard danceBoard = new DanceBoard();
        danceBoard.drawDancePad();
        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        terminal.flush();

    }

}
