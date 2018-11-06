package com.company;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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
        String message = "    Dance Academy";
        terminal.enableSGR(SGR.BLINK);
        terminal.setForegroundColor(TextColor.ANSI.CYAN);
        for (int i = 0; i < message.length(); i++) {
            Main.terminal.setCursorPosition(i, 1);
            Main.terminal.putCharacter(message.charAt(i));
        }
        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.disableSGR(SGR.BLINK);


///////////////////////////////////////////////////

        Song song = new Song();
        List<Arrow> allArrowsToUse = song.getQuiver();
        List<Arrow> quiver = new ArrayList<>();

        final int timeCounterThreshold = 80;
        int timeCounter = 0;


        while (true) {
            KeyStroke keyStroke;

            do {
                // everything inside this loop will be called approximately every ~5 millisec.
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
                timeCounter++;
                if (timeCounter >= timeCounterThreshold) {
                    // terminal.clearScreen();
                    timeCounter = 0;

                    addArrows(quiver, allArrowsToUse);
                    moveArrows(quiver);

                    checkIfHit(quiver,player);  ///////
                    if(player.isArrowPress()){
                        player.moveToPrevious();
                        player.setArrowPress(false);
                    }

                    drawArrows(quiver, terminal);

                    playingField.drawField();
                    drawCharacters(terminal, player);

                    terminal.flush(); // don't forget to flush to see any updates!
                }


            } while (keyStroke == null);

            movePlayer(player, keyStroke);
            drawCharacters(terminal, player);


            terminal.flush(); // don't forget to flush to see any updates!
        }

        //////////////////////////////////////////////


    }

    private static void addArrows(List<Arrow> quiver, List<Arrow> allArrowsToUse) {
        if (allArrowsToUse.isEmpty()) {
            return;
        }
        quiver.add(allArrowsToUse.remove(0));
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
                player.setArrowPress(true);
             //   player.moveDown();
                drawCharacters(terminal, player);
                break;
            case ArrowDown:
                player.moveDown();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.setArrowPress(true);
              //  player.moveUp();
                break;
            case ArrowLeft:
                player.moveLeft();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.setArrowPress(true);
                //player.moveRight();
                break;
            case ArrowRight:
                player.moveRight();
                drawCharacters(terminal, player);
                Thread.sleep(100);
                player.setArrowPress(true);
               // player.moveLeft();
                break;
        }
    }

    private static KeyStroke getUserKeyStroke(Terminal terminal) throws InterruptedException, IOException {
        KeyStroke keyStroke;
        do {
            Thread.sleep(20);
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

    private static void drawArrow(Arrow arrow, Terminal terminal) throws IOException {

        terminal.setCursorPosition(arrow.getX(), arrow.getY());
        terminal.putCharacter(arrow.getArrow());
        terminal.setCursorPosition(arrow.getX(), arrow.getY() - 1);
        terminal.putCharacter(' ');

    }

    private static void drawArrows(List<Arrow> quiver, Terminal terminal) throws IOException, InterruptedException {

        for (Arrow arrow : quiver) {


            terminal.setCursorPosition(arrow.getX(), arrow.getY());
            terminal.putCharacter(arrow.getArrow());
            terminal.setCursorPosition(arrow.getX(), arrow.getY() - 1);
            terminal.putCharacter(' ');

        }

    }


    private static void moveArrows(List<Arrow> quiver) throws InterruptedException {
        for (Arrow arrow : quiver) {

            arrow.fall(arrow);

        }
    }

    private static void checkIfHit(List<Arrow> arrowList, Player player) throws IOException,InterruptedException {
        KeyStroke left = new KeyStroke(KeyType.ArrowLeft);
        /*if (arrowList.isEmpty()) {
            return;
        }*/

        for (int i = 0; i < arrowList.size(); i++) {


        if (arrowList.get(i).getY() == 21 &&
                arrowList.get(i).getX() == 23 &&
                player.getX()!=9) {

          terminal.bell();
//          terminal.close();
        }
    }
    }

}
