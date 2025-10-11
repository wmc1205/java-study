package org.gof.designPatterns.factoryMethod;

// 구현 class
// Creator
public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
