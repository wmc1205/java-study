package org.gof.designPatterns.builder;

import org.gof.designPatterns.builder.before.TourPlan;

public class Client {

    public static void main(String[] args) {

        //builder 패턴 구현 객체를 new 로 생성하여 해당 객체에서 구현하는 tourPlan 객체 생성 메소드를 호출
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.longBeachTrip();

        System.out.println(tourPlan);


    }
}
