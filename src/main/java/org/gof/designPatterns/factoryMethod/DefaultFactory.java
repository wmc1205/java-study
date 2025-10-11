package org.gof.designPatterns.factoryMethod;

//Java 8 이하 버전에서는 default 메서드 사용 불가, 인터페이스에서 구현 메서드를 만들 수 없음
//추상 클래스를 하나 만들어서 인터페이스를 상속받은 다음 구현 메서드 생성
//결론 : Java 8 버전 이상이라면 그냥 인터페이스에서 default 메서드를 사용하자.
public abstract class DefaultFactory implements ShipFactory {
    /*
    @Override
    public void sendEmailTo(String email, Ship ship) {
            System.out.println("Finished making " + ship.getName() + "!!!");
    }
     */
}
