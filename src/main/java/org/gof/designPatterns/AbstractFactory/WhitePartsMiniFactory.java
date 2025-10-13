package org.gof.designPatterns.AbstractFactory;

public class WhitePartsMiniFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchorMini();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheelMini();
    }
}
