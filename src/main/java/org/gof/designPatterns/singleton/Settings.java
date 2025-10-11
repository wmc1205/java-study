package org.gof.designPatterns.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

    private static final Settings INSTANCE = new Settings();

    /**
     * 생성자를 private 하게 만드는 이유?
     * 인스턴스를 생성하는 클래스에서 제공하는 메서드를 통해서만 생성자를 호출할 수 있도록 접근을 막기 위함.
     * 해당 클래스를 호출하는 다른 클래스에서 해당 생성자를 직접 생성하지 못한다(new Settings());
     */
    private Settings() {}

    /**
     * 4.static inner class 생성
     */
    private static class SettingsHolder {
        //private static final Settings INSTANCE = new Settings();
    }


    /**
     * 2. syncronized 사용하기
     * synronized 를 사용하는 이유?
     * 멀티쓰레드 환경에서 공유하는 인스턴스가 달라질 수 있다.
     * 쓰레드에 안전하게 처리하기 위해 동기화하는 syncronized 키워드 사용
     * 단점 : getInstance() 메서드를 호출할 때마다, 동기화 작업이 추가되기 때문에 성능의 하락이 발생할 수 있다.
     *
     * 해당 객체를 생성하는데에 비용이 크게 발생하지 않다면, 이른 초기화(eager Initialization) 사용
     * 인스턴스 변수에 final 키워드 사용
     * syncronized 키워드 사용하지 않아도 쓰레드로부터 안전하다.

     public static synchronized  Settings getInstance() {
        return instance;
     }
     */

    /** 3. double checked locking 사용하기
     * 게으른 초기화(lazy Initialization)
     * 만약 인스턴스 객체를 나중에 만들어도 괜찮다면? double checked locking 으로 효율적인 동기화 블럭을 만들 수 있다.
     * 장점 1) 멀티 쓰레드 환경에서 syncronized 보다 더 빠른 성능으로 쓰레드에 안전하게 인스턴스를 생성할 수 있다.
     * 장점 2) 필요한 시점에 인스턴스를 생성할 수 있다.
     * public static Settings getInstance() {
     *         if(instance == null){ //check 1
     *             synchronized (Settings.class){
     *                 if(instance == null){ //check 2
     *                     instance = new Settings();
     *                 }
     *             }
     *         }
     *         return instance;
     *
     *     }
     */

    /**
     * 4.stattic inner class 사용하기
     *
     */
    public static Settings getInstance() {
        return INSTANCE;
    }

    /**
     * App2 -> 2)직렬화 & 역직렬화로 singleton 깨뜨리기에 대한 역직렬화 대응방법
     * 역직렬 시, 해당 메서드가 대체되어 호출된다.
     * @return
     */
    protected Object readResolve() {
        return getInstance();
    }

}
