package com.company;

import java.util.ArrayList;
import java.util.List;

public class Song {
    List<Arrow> quiver = new ArrayList<>();

    //put song arrows here

    Song() {
        addArrow("left");
        addArrow("right");
        addArrow("fel");
        addArrow("right");
        addArrow("down");
        addArrow("up");


    }


    public void addArrow(String direction) {
        switch (direction) {
            case "left":
                this.quiver.add(new Arrow(23, 0, '\u21d0'));
                break;
            case "down":
                this.quiver.add(new Arrow(29, 0, '\u21d3'));
                break;
            case "up":
                this.quiver.add(new Arrow(35, 0, '\u21d1'));
                break;
            case "right":
                this.quiver.add(new Arrow(41, 0, '\u21d2'));
                break;
            default:
                this.quiver.add(new Arrow(2, 0, 'T'));
                break;
        }
    }


    public List<Arrow> getQuiver() {
        return quiver;
    }
}

