package org.gof.designPatterns.factoryMethod;

import org.gof.designPatterns.AbstractFactory.Anchor;
import org.gof.designPatterns.AbstractFactory.Wheel;

// Product
public class Ship {
    // open closed principle
    // 확장에는 열려있고, 변경에는 닫혀 있어야 한다.
    // 즉 코드의 확장이 있어도 해당 코드의 변경은 없어야 한다.
    private String name;
    private String color;
    private String logo;

    private Anchor anchor;
    private Wheel wheel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public Anchor getAnchor() {
        return anchor;
    }
    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }
    public Wheel getWheel() {
        return wheel;
    }
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
