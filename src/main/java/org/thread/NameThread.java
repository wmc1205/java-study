package org.thread;

public class NameThread extends Thread {

    private int threadNumber;
    public NameThread(String name,int threadNumber) {
        super(name);
        this.threadNumber = threadNumber;
    }
    public void run() {
        threadNumber++;
        System.out.println("Thread" + threadNumber + " run() method success!");
    }

}
