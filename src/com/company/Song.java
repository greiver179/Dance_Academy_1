package com.company;

import java.util.ArrayList;
import java.util.List;

public class Song {
    List<Arrow> quiver = new ArrayList<>();

    //put song arrows here

    Song() {
        for (int i = 0; i < 18; i++) {
            addArrow("pause");
        }
        addArrow("left");
        addArrow("q");
        addArrow("left");
        addArrow("q");
        addArrow("left");
        addArrow("q");
        addArrow("left");
        for (int i = 0; i < 17; i++) {
            addArrow("q");
        }

        addArrow("up");
        addArrow("q");
        addArrow("right");
        addArrow("q");
        addArrow("down");
        addArrow("q");
        addArrow("left");
        addArrow("q");
        addArrow("left");
        addArrow("q");
        addArrow("up");

        addArrow("up");
        addArrow("q");
        addArrow("down");
        addArrow("q");
        addArrow("down");
        addArrow("q");
        addArrow("right");

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
                this.quiver.add(new Arrow(0, 0, ' '));
                break;
        }
    }


    public List<Arrow> getQuiver() {
        return quiver;
    }
}

