package org.thread;

import java.util.concurrent.CountDownLatch;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ThreadLocal {

    // ThreadLocal 변수 선언
    private static java.lang.ThreadLocal<String> threadLocalValue = new java.lang.ThreadLocal<>();
    private static java.lang.ThreadLocal<Integer> threadLocalCounter = java.lang.ThreadLocal.withInitial(() -> 0);
    public static void main(String[] args) {
        try {
            basicThreadLocalTest();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static public void basicThreadLocalTest() throws InterruptedException {
        System.out.println("=== 기본 ThreadLocal 테스트 ===");

        // 메인 스레드에서 값 설정
        threadLocalValue.set("메인 스레드 값");
        System.out.println("메인 스레드: " + threadLocalValue.get());

        CountDownLatch latch = new CountDownLatch(2);

        // 첫 번째 스레드
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set("스레드1 값");
            System.out.println("스레드1: " + threadLocalValue.get());
            latch.countDown();
        });

        // 두 번째 스레드
        Thread thread2 = new Thread(() -> {
            threadLocalValue.set("스레드2 값");
            System.out.println("스레드2: " + threadLocalValue.get());
            latch.countDown();
        });

        thread1.start();
        thread2.start();

        latch.await();

        // 메인 스레드에서 다시 확인 (변경되지 않음)
        System.out.println("메인 스레드 (다시): " + threadLocalValue.get());
    }

    
    static public void simpleThreadLocalCounterTest() throws InterruptedException {
        System.out.println("\n=== 간단한 ThreadLocal 카운터 테스트 ===");

        java.lang.ThreadLocal<Integer> counter = java.lang.ThreadLocal.withInitial(() -> 10);

        // 스레드 A
        Thread threadA = new Thread(() -> {
            System.out.println("[스레드A] 시작값: " + counter.get());
            counter.set(counter.get() + 10);
            System.out.println("[스레드A] 10 더한 후: " + counter.get());
            counter.set(counter.get() + 5);
            System.out.println("[스레드A] 5 더한 후 최종값: " + counter.get());
        });

        // 스레드 B
        Thread threadB = new Thread(() -> {
            System.out.println("[스레드B] 시작값: " + counter.get());
            counter.set(counter.get() + 100);
            System.out.println("[스레드B] 100 더한 후: " + counter.get());
            counter.set(counter.get() + 20);
            System.out.println("[스레드B] 20 더한 후 최종값: " + counter.get());
        });

        threadA.start(); //쓰레드 A 시작
        threadB.start(); //쓰레드 B 시작

        threadA.join(); // 쓰레드 A가 종료될 때 까지 메인 쓰레드 지연
        threadB.join(); // 쓰레드 B가 종료될 때 까지 메인 쓰레드 지연

        System.out.println("[메인스레드] 값: " + counter.get()); // 초기값 0
    }

    
    static public void threadLocalMemoryLeakPreventionTest() throws InterruptedException {
        System.out.println("\n=== ThreadLocal 메모리 누수 방지 테스트 ===");

        java.lang.ThreadLocal<String> localVar = new java.lang.ThreadLocal<>();

        Thread thread = new Thread(() -> {
            localVar.set("임시 데이터");
            System.out.println("설정된 값: " + localVar.get());

            // 사용 후 반드시 remove() 호출하여 메모리 누수 방지
            localVar.remove();
            System.out.println("remove() 후 값: " + localVar.get()); // null
        });

        thread.start();
        thread.join();
    }

    /*
        일반 ThreadLocal : 스레드 간 완전한 독립 실행
        InheritableThreadLocal : 부모 스레드의 값을 자식 스레드가 상속받는다.
     */
    
    static public void threadLocalInheritanceTest() throws InterruptedException {
        System.out.println("\n=== InheritableThreadLocal 테스트 ===");

        //부모 ThreadLocal 생성
        InheritableThreadLocal<String> inheritableLocal = new InheritableThreadLocal<>();

        // 부모 스레드에서 값 설정
        inheritableLocal.set("부모 스레드의 값");
        System.out.println("부모 스레드: " + inheritableLocal.get());

        Thread childThread = new Thread(() -> {
            // 자식 스레드는 부모의 값을 상속받음
            System.out.println("자식 스레드 (상속받은 값): " + inheritableLocal.get());

            // 자식에서 값 변경
            inheritableLocal.set("자식 스레드가 변경한 값");
            System.out.println("자식 스레드 (변경 후): " + inheritableLocal.get());
        });

        childThread.start();
        childThread.join();

        // 부모 스레드의 값은 변경되지 않음
        System.out.println("부모 스레드 (자식 변경 후): " + inheritableLocal.get());
    }
}