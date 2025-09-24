package org.gof.strategy.sampleRobot;

public class Korean implements TranslateStrategy{
    public void translate(String robotName){
        System.out.println(robotName + " : Korean Translating...");
    }
}
