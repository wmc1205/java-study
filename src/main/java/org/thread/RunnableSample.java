package org.thread;

public class RunnableSample implements Runnable {
    //쓰레드가 수행되는 메서드
    @Override
    public void run() {
        System.out.println("RunnableSample run method success!");
    }
}
