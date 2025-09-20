package org.thread.Syncronized;

public class CommonCalculate {

    private int amount;
    private int interest;
    final Object amountLock = new Object();
    final Object interestLock = new Object();
    public CommonCalculate() {
        amount = 0;
    }
    public void plus(int value) {
        //메서드 전체가 아닌, 필요한 연산만 syncronized로 처리 하면 불필요한 대기 시간이 발생하지 않는다.
        synchronized (amountLock) {
            amount += value;
        }

        // amount = amount + value
    }

    //별도의 syncronized 객체를 사용하게 되면 여러 변수에 대해 쓰레드로부터 안전하게 처리할 수 있다.
    public void interestPlus(int value) {
        synchronized (interestLock) {
            interest+= value;
        }
    }

    public void minus(int value) {
        amount -= value;
        // amoun = amount - value
    }

    public synchronized void syncPlus(int value) {
        amount += value;
    }
    public synchronized void syncMinus(int value) {
        amount -= value;
    }

    public int getAmount(){
        return amount;
    }
}
