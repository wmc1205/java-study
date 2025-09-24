package org.gof.strategy.sampleRobot;

public class Host {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new Run(), new Korean());
        robot1.setRobotName("robot1");

        robot1.setMoveStrategy(robot1.moveStrategy);
        robot1.setTranslateStrategy(robot1.translateStrategy);

        robot1.move();
        robot1.translate();

        Robot robot2 = new Robot(new Walk(), new Japanese());
        robot2.setRobotName("robot2");

        robot2.setMoveStrategy(robot2.moveStrategy);
        robot2.setTranslateStrategy(robot2.translateStrategy);

        robot2.move();
        robot2.translate();

    }

}
