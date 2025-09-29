package org.gof.strategySample.sampleRobot;

public class Japanese implements TranslateStrategy{
    public void translate(String robotName){
        System.out.println(robotName + " : Japanese Translating...");
    }
}
