package org.gof.strategySample.sampleRobot;

public class English implements TranslateStrategy{
    public void translate(String robotName){
        System.out.println(robotName + " : English Translating...");
    }
}
