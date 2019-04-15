package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    String [][] board = new String [10][10];

    public void setBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10 ; j++) {
                board[i][j] = "O";
            }
        }
    }

    public void getBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void addShipsToBoard(List<Ship> ships){
        for(Ship ship : ships){
            List<Point> points = new ArrayList<>();
            boolean isEmptyPlace = true;
            do {
                ship.setPoint();
                points = placeForShip(ship.getPoint(), ship);
                for (Point p : points) {
                    if(!board[(int) p.getX()][(int) p.getY()].equals("O")){
                        isEmptyPlace = false;
                        break;
                    }
                }
            }while(!isEmptyPlace);
            System.out.println("Success for ship called" + ship.name);
            for(Point p: points){
                board[(int) p.getX()][(int) p.getY()] = ship.name;

            }
        }
    }

    public List<Point> placeForShip(Point randomPoint, Ship ship){
        List<Point> pointsForShip = new ArrayList<>();
        for (int i = 0; i < ship.length; i++) {

            if(ship.orientation){

                pointsForShip.add(new Point((int)randomPoint.getX() +i, (int)randomPoint.getY()));

            }
            else{
                pointsForShip.add(new Point((int)randomPoint.getX(), (int)randomPoint.getY()+ i));
            }

        }
//        testowanie
//        for(Point p : pointsForShip) System.out.println(p);
        return pointsForShip;
    }


}
