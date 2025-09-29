package org.gof.strategySample;

public class ConcreteStrategyA implements MainStrategy {

    //추상 인터페이스의 메서드를 오버라이딩
    public void doSomething() {
        System.out.println("ConcreteStrategyA doSomething!");
    }
}
