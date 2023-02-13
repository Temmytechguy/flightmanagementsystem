package com.temmy.bddfundamental.airport;

import com.temmy.fms.airport.Passenger;
import com.temmy.fms.mileage.Mileage;
import com.temmy.fms.mileage.StatisticsUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Statistics {

    private Passenger mike;
    private Passenger john;
    private Mileage mileage;

    @Given("^There is a usual passenger$")
    public void thereIsAUsualPassenger() {

        mike = new Passenger("Mike", false);
        mileage = new Mileage();
    }

    @And("^there is a VIP passenger$")
    public void thereIsAVIPPassenger() {

        john = new Passenger("John", true);
    }

    @When("^the usual passenger travels distance (\\d+) and (\\d+) and (\\d+)$")
    public void theUsualPassengerTravelsDistanceDistanceAndDistanceAndDistance(int distance1, int distance2, int distance3) {

        mileage.addMileageToList(mike, distance1);
        mileage.addMileageToList(mike, distance2);
        mileage.addMileageToList(mike, distance3);
    }

    @And("^the VIP passenger travels distance (\\d+) and (\\d+) and (\\d+)$")
    public void theVIPPassengerTravelsDistanceDistanceAndDistanceAndDistance(int distance4, int distance5, int distance6) {

        mileage.addMileageToList(john, distance4);
        mileage.addMileageToList(john, distance5);
        mileage.addMileageToList(john, distance6);
    }

    @Then("^the total travel distance should be (\\d+)$")
    public void theTotalTravelDistanceShouldBeTotal_distance(int total_distance) {

        assertEquals(total_distance, StatisticsUtil.totalDistance(mileage));
    }
}
