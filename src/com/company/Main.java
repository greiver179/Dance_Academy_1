package com.company;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Terminal terminal;

    public static void main(String[] args) throws IOException, InterruptedException {
        terminal = createTerminal();
        Player player = createPlayer();
        PlayingField playingField = new PlayingField();
        playingField.drawField();
        drawCharacters(terminal, player);
        MusicPlayer music = new MusicPlayer();
        music.play("music.mp3");

       /* if ( (p.getX() ??? e.getX()) && (p.getY() ??? e.getY()) ){
            // GAME OVER
        }*/

///////////////////////////////////////////////////



        final int timeCounterThreshold = 80;
        int timeCounter = 0;
        Song song = new Song();
        List<Arrow> quiver = song.getQuiver();
        quiver.add(new Arrow(23,0,'T'));



        while(true){
            KeyStroke keyStroke;

            do {
                // everything inside this loop will be called approximately every ~5 millisec.
                Thread.sleep(1);
                keyStroke = terminal.pollInput();
                timeCounter++;
                if (timeCounter >= timeCounterThreshold){
                    timeCounter = 0;


                    moveArrows(quiver);


                    drawArrows(quiver,terminal);
                    playingField.drawField();



                    drawCharacters(terminal, player);
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

   /* public static void drawArrow (Terminal terminal, Arrow arrow) throws IOException {
        terminal.clearScreen();
        terminal.setCursorPosition(arrow.getX(), arrow.getY());
        terminal.putCharacter(arrow.getArrow());

    }
*/
    private static void drawArrows(List<Arrow> quiver, Terminal terminal) throws IOException {
        terminal.clearScreen();
        for (Arrow arrow : quiver) {
            terminal.setCursorPosition(arrow.getX(), arrow.getY());
            terminal.putCharacter(arrow.getArrow());
        }

    }


    private static void moveArrows(List<Arrow> quiver) {
        for (Arrow arrow : quiver) {
            arrow.fall();
        }
    }

}
