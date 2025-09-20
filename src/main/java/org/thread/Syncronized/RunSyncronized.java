package org.thread.Syncronized;

public class RunSyncronized {

    public static void main(String[] args) {
        RunSyncronized runSyncronized = new RunSyncronized();
        for(int loop=0;loop<10;loop++){
            runSyncronized.runCommonCalculate();
        }

    }

    public void runCommonCalculate(){
        CommonCalculate commonCalculate = new CommonCalculate();
        ModifyAmountThread thread1 = new ModifyAmountThread(commonCalculate,true);
        ModifyAmountThread thread2 = new ModifyAmountThread(commonCalculate,true);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // thread1 가 종료될 때 까지 기다리는 메소드
            thread2.join(); // thread2 가 종료될 때 까지 기다리는 메소드
            System.out.println("Final value is " + commonCalculate.getAmount());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //정상적이라면 thread1,2 모두 true니까 20,000 이 출력되어야 한다.
    //하지만 실제 출력 결과
            /*
                Final value is 12569
                Final value is 17000
                Final value is 14936
                Final value is 11645
                Final value is 12751
                Final value is 19906
                Final value is 19426
                Final value is 20000
                Final value is 20000
                Final value is 19838
             */

    //syncronized 예약어를 메서드에 추가시키고 실행하면,
            /*
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
                Final value is 20000
             */
}
