package org.gof.strategy;

import javax.naming.Context;

public class Client {
    public static void main(String[] args) {
        //1.컨텍스트 생성
        StrategyContext ctx = new StrategyContext();

        //2.전략설정
        ctx.setStrategy(new ConcreteStrategyA());

        //3.전략실행
        ctx.doAnything();

        //4.전략교체
        ctx.setStrategy(new ConcreteStrategyB());

        //5.교체한 전략 실행
        ctx.doAnything();
    }
}
