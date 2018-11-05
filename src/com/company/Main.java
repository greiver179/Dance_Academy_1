package com.company;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    public static Terminal terminal;

    public static void main(String[] args) throws IOException, InterruptedException {
        terminal = createTerminal();
        Player player = createPlayer();
        PlayingField playingField = new PlayingField();
        playingField.drawField();
        drawCharacters(terminal, player);
///////////////////////////////////////////////////
        final int timeCounterThreshold = 80;
        int timeCounter = 0;
        while(true){
            KeyStroke keyStroke;
            do {
                // everything inside this loop will be called approximately every ~5 millisec.
                Thread.sleep(5);
                keyStroke = terminal.pollInput();

                timeCounter++;
                if (timeCounter >= timeCounterThreshold){
                    timeCounter = 0;
                    keyStroke = getUserKeyStroke(terminal);
                    movePlayer(player, keyStroke);
                    drawCharacters(terminal, player);
                    ArrowField arrowField = new ArrowField();
                    arrowField.spawnLeft();
                    Arrow arrow = new Arrow(23,0,'T');
                    arrow.fall();

                    /*addRandomFlakes(snowFlakes);
                    moveSnowFlakes(snowFlakes);
                    removeDeadFlakes(snowFlakes);
                    printSnowFlakes(snowFlakes, terminal);
                    printPlayer(terminal, player);*/

                    terminal.flush(); // don't forget to flush to see any updates!
                }


            } while (keyStroke == null);

            movePlayer(player, keyStroke);
            drawCharacters(terminal, player);

            terminal.flush(); // don't forget to flush to see any updates!
        }

      //////////////////////////////////////////////







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


    private static void movePlayer(Player player, KeyStroke keyStroke) throws InterruptedException, IOException {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                player.moveUp();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.moveDown();
                drawCharacters(terminal, player);
                break;
            case ArrowDown:
                player.moveDown();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.moveUp();
                break;
            case ArrowLeft:
                player.moveLeft();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.moveRight();
                break;
            case ArrowRight:
                player.moveRight();
                drawCharacters(terminal, player);
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

        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');
        danceBoard.drawDancePad();
        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        terminal.flush();

    }

}
