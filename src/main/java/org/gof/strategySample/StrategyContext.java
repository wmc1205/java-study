package org.gof.strategySample;

public class StrategyContext {
    MainStrategy mainStrategy; //전략 인터페이스를 합성(Composition)

    //전략 교체 메소드
    void setStrategy(MainStrategy mainStrategy) {
        this.mainStrategy = mainStrategy;
    }

    //전략 실행 메소드
    void doAnything() {
        this.mainStrategy.doSomething();
    }
}
