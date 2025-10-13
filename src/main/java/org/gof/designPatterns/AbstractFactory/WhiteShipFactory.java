package org.gof.designPatterns.AbstractFactory;

import org.gof.designPatterns.factoryMethod.DefaultFactory;
import org.gof.designPatterns.factoryMethod.Ship;
import org.gof.designPatterns.factoryMethod.WhiteShip;

public class WhiteShipFactory extends DefaultFactory {
    //추상 펙토리 사용
    private ShipPartsFactory shipPartsFactory;
    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Ship createShip() {
        //구현체를 숨기고, 구현체를 생성하는 인터페이스를 호출
        //클라이언트는 해당 WhiteShipFactory를 호출하는 것으로 해당 Product를 사용할 수 있다.
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
