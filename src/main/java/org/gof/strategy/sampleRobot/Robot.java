package org.gof.strategy.sampleRobot;

public class Robot {
    MoveStrategy moveStrategy;
    TranslateStrategy translateStrategy;
    String robotName;

    public Robot(MoveStrategy moveStrategy, TranslateStrategy translateStrategy) {
        this.moveStrategy = moveStrategy;
        this.translateStrategy = translateStrategy;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public void move(){
        System.out.println("[" + robotName + "] calling move():");
        moveStrategy.move(robotName);
    }
    public void translate(){
        System.out.println("[" + robotName + "] calling translate():");
        translateStrategy.translate(robotName);
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void setTranslateStrategy(TranslateStrategy translateStrategy) {
        this.translateStrategy = translateStrategy;
    }
}
