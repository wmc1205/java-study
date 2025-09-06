package org.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Java Study Application Started - Debugging Ready");
        
        NameThread nameThread = new NameThread("MyThread", 4);
        nameThread.start();
        
        // 디버깅을 위해 애플리케이션을 계속 실행
        Thread.sleep(180000); // 60초 대기
        
        System.out.println("Application finished");

    }
}
