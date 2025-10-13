package org.gof.designPatterns.factoryMethod;

// 구현 class
// ConcreteCreator
public class BlackShipFactory implements ShipFactory {
 public Ship createShip() {
        return new BlackShip();
    }
}
