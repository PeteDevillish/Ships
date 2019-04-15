package com.company;

import java.util.*;

public class HarbourFullOfShip {
    List<Ship> ships = new ArrayList<Ship>(Arrays.asList(
            new Ship(1, "Błażejowa Strzała"),
            new Ship(2, "Łajba Mariusza"),
            new Ship(2, "Mądrości Mateusza"),
            new Ship(3, "Zacisze Dagmary"),
            new Ship(4, "Hardy Węgorz"),
            new Ship(5, "Słoneczna Zatoka")
    ));

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(int length, String name){
        ships.add(new Ship(length, name));
    }

    public Ship randomShip(){
        int numberOfRandomShip =(int)(Math.random() *(ships.size()-1));
        Ship toReturn = ships.get(numberOfRandomShip);
        ships.remove(numberOfRandomShip);
        return toReturn;
    }

    public List<Ship> randomShips(){
        List <Ship> randomShips = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            randomShips.add(randomShip());
        }
        return randomShips;
    }




}
