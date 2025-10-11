package org.gof.designPatterns.factoryMethod;

// 인터페이스(추상)
// Creator
public interface ShipFactory {
    //default 메서드
    //인터페이스 내부에서 구현 메서드를 생성(Java 8 부터 가능)
    //public 이기 때문에 모든 클래스에서 호출 가능
    default Ship orderShip(String name, String email){
        validate(name,email);
        prepareFor(name);

        Ship ship = createShip();
        sendEmailTo(email,ship);
        return ship;
    }

    //default 메서드는 모든 클래스에서 접근 가능하나
    //private 메서드는 같은 인터페이스 내부 메서드(해당 인터페이스를 상속하는 구현 클래스 포함)만 사용 가능하다.
    private void sendEmailTo(String email, Ship ship){
            System.out.println("Finished making " + ship.getName() + "!!!");
    };

    Ship createShip();

    private void validate(String name,String email){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Ship name cannot be empty");
        }

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Ship email cannot be empty");
        }
    }

    private static void prepareFor(String name){
        System.out.println("Preparing for "+ name + "...");
    }
}
