package com.company;

import java.awt.*;
import java.util.Random;

public class Ship {

    int length;
    Boolean isSunk = false;
//    true => horizontal(poziomo, false => vertical (pionomo)
    boolean orientation = true;
    String name;
    Point point = new Point();
    public Ship(int length, String name) {
        this.length = length;
        this.name = name;
        //Da się tu coś zmienić?
        Random random = new Random();
        orientation = random.nextBoolean();
    }

    public Ship(int length, String name, Point point) {
        this.length = length;
        this.name = name;
        //Da się tu coś zmienić?
        Random random = new Random();
        orientation = random.nextBoolean();
        this.point = point;

    }

    public void setPoint() {
        int x, y;
        if(orientation){
        x = (int)(Math.random() *(10-length));
        y = (int)(Math.random() *10);}
        else {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * (10 - length));
        }
        this.point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }


}
