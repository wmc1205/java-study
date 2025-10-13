package org.gof.designPatterns.AbstractFactory;

import org.gof.designPatterns.factoryMethod.Ship;
import org.gof.designPatterns.factoryMethod.ShipFactory;


public class ShipClient {
    public static void main(String[] args) {
       ShipFactory shipFactory = new WhiteShipFactory(new WhitePartsMiniFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass().getName());
        System.out.println(ship.getWheel().getClass().getName());
    }
}
