package org.thread;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads runThreads = new RunThreads();
        runThreads.runBasic();
    }
    public void runBasic() {
        Runnable runnable = new RunnableSample();
        new Thread(runnable).start();

        ThreadSample thread = new ThreadSample();
        thread.start();
        System.out.println("RunnableSample runBasic() method success!");
    }
}
