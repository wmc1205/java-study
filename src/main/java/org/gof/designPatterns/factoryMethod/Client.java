package org.gof.designPatterns.factoryMethod;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        Ship whiteShip = new WhiteShipFactory().orderShip("Whiteship","wmc@naver.com");
        System.out.println(whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("Blackship","wmc@naver.com");
        System.out.println(blackShip);
    }
}
