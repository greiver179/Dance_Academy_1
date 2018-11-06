package com.company;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;

import static com.company.Main.terminal;

public class Player {
    private int x;
    private int y;
    private char symbol;
    private int previousX;
    private int previousY;
    boolean arrowPress;

    public Player(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.previousX = x;
        this.previousY = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPreviousX() {
        return previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void moveUp() {
        previousX = x;
        previousY = y;
        y--;
    }

    public void moveDown() {
        previousX = x;
        previousY = y;
        y++;
    }

    public void moveLeft() {
        previousX = x;
        previousY = y;
        x--;
    }

    public void moveRight() {
        previousX = x;
        previousY = y;
        x++;
    }

    public void moveToPrevious() {
        this.x = previousX;
        this.y = previousY;
    }

    public boolean isArrowPress() {
        return arrowPress;
    }

    public void setArrowPress(boolean arrowPress) {
        this.arrowPress = arrowPress;
    }

    @Override
    public String toString() {
        return "Player{" +
                "x=" + x +
                ", y=" + y +
                ", symbol=" + symbol +
                ", previousX=" + previousX +
                ", previousY=" + previousY +
                '}';
    }

}
