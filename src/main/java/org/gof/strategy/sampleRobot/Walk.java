package org.gof.strategy.sampleRobot;

public class Walk implements MoveStrategy{
    public void move(String robotName){
        System.out.println(robotName + " : Walking...");
    }
}
