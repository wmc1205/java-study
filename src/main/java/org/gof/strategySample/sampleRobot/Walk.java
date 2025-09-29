package org.gof.strategySample.sampleRobot;

public class Walk implements MoveStrategy{
    public void move(String robotName){
        System.out.println(robotName + " : Walking...");
    }
}
