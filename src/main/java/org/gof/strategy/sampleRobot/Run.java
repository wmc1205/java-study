package org.gof.strategy.sampleRobot;

public class Run implements MoveStrategy{
    public void move(String robotName){
        System.out.println(robotName + " : Running...");
    }
}
