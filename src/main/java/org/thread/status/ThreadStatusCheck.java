package org.thread.status;

public class ThreadStatusCheck extends Thread {

    private Object monitor;
    public ThreadStatusCheck(Object monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try{
            for(int l=0;l<10000;l++){
                String a = "A";
            }
            synchronized (monitor){
                monitor.wait();
            }
            System.out.println(getName()+"is notified");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /* Thread 상태값 확인

    private final Thread target;

    public ThreadStatusCheck(String name, Thread target) {
        super(name);
        this.target = target;
    }

    @Override
    public void run() {
        for(int i=0; i<=2_000_000_000; i++);
        for(int i=0; i<=2_000_000_000; i++);
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            target.join();
        }catch(InterruptedException e){
            for(int x=0; x<=2_000_000_000L; x++);
            for(int x=0; x<=2_000_000_000L; x++);
        }
    }
     */
}
