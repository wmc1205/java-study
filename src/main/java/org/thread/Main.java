package org.thread;

public class Main {
    public static void main(String[] args) {
        NameThread nameThread = new NameThread("MyThread", 4);
        nameThread.start();
    }
}
