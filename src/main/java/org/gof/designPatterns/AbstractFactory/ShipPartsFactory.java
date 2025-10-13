package org.gof.designPatterns.AbstractFactory;

public interface ShipPartsFactory {
    Anchor createAnchor();

    Wheel createWheel();
}
