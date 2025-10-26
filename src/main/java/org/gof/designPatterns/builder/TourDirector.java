package org.gof.designPatterns.builder;

import org.gof.designPatterns.builder.before.TourPlan;

import java.time.LocalDate;

//builder 구현 객체 생성
public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip(){
        return tourPlanBuilder.title("칸쿤")
                .nightAndDays(2,3)
                .startDate(LocalDate.of(2025,11,1))
                .whereToStay("리조트")
                .addPlan(0,"체크인하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();
    }

    public TourPlan longBeachTrip(){
        return tourPlanBuilder.title("롱비치")
                .nightAndDays(2,3)
                .startDate(LocalDate.of(2025,12,1))
                .whereToStay("크루즈")
                .addPlan(0,"체크인하고 짐 풀기")
                .addPlan(0, "점심 식사")
                .getPlan();
    }

}
