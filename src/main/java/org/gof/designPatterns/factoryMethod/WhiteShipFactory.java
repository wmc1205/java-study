package org.gof.designPatterns.factoryMethod;

// 구현 class
// ConcreteCreator
public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
