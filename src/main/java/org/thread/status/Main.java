package org.thread.status;

public class Main {
    private static Thread myThread1;
    private static Thread statusThread;

    public static void main(String[] args) {

        Main sample = new Main();
        sample.checkThreadState2() ;

    }
    public void checkThreadState() {

        statusThread = new Thread(() -> {
            while(true){
                Thread.State state = myThread1.getState();
                System.out.printf("[%s] - Thread... [%s]\n",myThread1.getName(),state);
                if(state == Thread.State.NEW){
                    myThread1.start();
                }
                if(state == Thread.State.WAITING){
                    myThread1.interrupt();
                }
                if(state == Thread.State.TERMINATED){
                    System.out.printf("[%s] - Thread end... [%s]\n",myThread1.getName(),state);
                }

                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        //myThread1 = new ThreadStatusCheck("myThread1", statusThread);
        //statusThread.start();

    }
    public void checkThreadState2() {
        Object monitor = new Object();
        ThreadStatusCheck thread = new ThreadStatusCheck(monitor);
        try{
            System.out.println("thread state="+ thread.getState());
            thread.start();
            System.out.println("thread state="+ thread.getState());

            Thread.sleep(100);
            System.out.println("thread state="+ thread.getState());
            synchronized (monitor){
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("thread state="+ thread.getState());

            thread.join();
            System.out.println("thread state="+ thread.getState());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
