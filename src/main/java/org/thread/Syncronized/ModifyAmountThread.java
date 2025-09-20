package org.thread.Syncronized;

public class ModifyAmountThread extends Thread {

    //객체를 매개변수로 설정
    private CommonCalculate calc;
    private boolean addFlag;

    public ModifyAmountThread(CommonCalculate calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
    }

    public void run() {
        for(int loop=0;loop<10000;loop++){
            if(addFlag){
                //calc.plus(1);

                calc.plus(1);
                calc.syncMinus(1);
            }else{
                //calc.minus(1);

            }
        }
    }
}
