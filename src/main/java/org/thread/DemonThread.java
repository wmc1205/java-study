package org.thread;

public class DemonThread extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(1000L);
            System.out.println("Daemon thread running");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void runCommonThread() throws InterruptedException {
        DemonThread thread1 = new DemonThread();
        Thread thread2 = new Thread();
        //demon 설정
        thread1.setDaemon(true);
        thread2.setDaemon(false);
        thread2.sleep(100L);
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        runCommonThread();

        //결과 : demon 으로 설정된 thread는 종료되지 않더라도, 다른 일반 쓰레드가 실행 중이 아니라면, 종료된다.
    }
}
