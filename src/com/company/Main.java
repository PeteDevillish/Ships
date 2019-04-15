package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Gameplay testee = new Gameplay();
        testee.setBoards();
        testee.boardWithShips();
        while(testee.isAnyShipOnTheSea()) {
            System.out.println(testee.shipsOnTheOcean.size());
            testee.visibleBoard();
        }
    }
}
