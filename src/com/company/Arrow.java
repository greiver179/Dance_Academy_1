package com.company;

public class Arrow {
    private int x;
    private int y;
    private char symbol;

    public Arrow(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
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

    public void fall(){
        y++;
    }





    private void speed(){ //Speed of the arrow falling down
        //Hello

    }

    private void direction(){ //direction of the arrow

    }

    private boolean isItHit(){//did you miss or hit the arrow at the right time
        return false;
    }






}
