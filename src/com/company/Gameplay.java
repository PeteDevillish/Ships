package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Gameplay {

    Board invisibleBoard = new Board();
    Board visibleBoard = new Board();
    HarbourFullOfShip harbour = new HarbourFullOfShip();
    List<Ship> shipsOnTheOcean = harbour.randomShips();

    void setBoards() {
        invisibleBoard.setBoard();
        visibleBoard.setBoard();
    }

    void boardWithShips() {
        invisibleBoard.addShipsToBoard(shipsOnTheOcean);
        invisibleBoard.getBoard();
    }

    void visibleBoard() {
        int[] point = choosePoint();
        String valueOfPoint = invisibleBoard.board[point[0]][point[1]];
        if (valueOfPoint.equals("O")) {
            invisibleBoard.board[point[0]][point[1]] = "X";
            visibleBoard.board[point[0]][point[1]] = "X";
            System.out.println("Pudło");
        } else if (!valueOfPoint.equals("X") && !valueOfPoint.equals("O")) {
            System.out.println("Trafiony " + invisibleBoard.board[point[0]][point[1]]);
            shipsOnTheOcean.forEach((ship -> {
                if (ship.name.equals(valueOfPoint)) {
                    ship.length--;
                    if (ship.length == 0) {
                        System.out.println("Zatopiony");
                        ship.isSunk = true;
                    }
                }
            }));
            invisibleBoard.board[point[0]][point[1]] = "V";
            visibleBoard.board[point[0]][point[1]] = "V";
        }
        visibleBoard.getBoard();
    }

    int[] choosePoint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose column");
        int x = sc.nextInt();
        System.out.println("Choose row");
        int y = sc.nextInt();
        int[] point = {y, x};
        return point;
    }


    boolean isAnyShipOnTheSea() {
        boolean isAnyShipOnTheBoard = true;
        List<Ship> local = shipsOnTheOcean.stream().filter(ship -> ship.isSunk.equals(false)).collect(Collectors.toList());
        shipsOnTheOcean = local;
        if(shipsOnTheOcean.size() == 0) {isAnyShipOnTheBoard = false;}
        return isAnyShipOnTheBoard;
    }
}
