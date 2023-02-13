package com.temmy.bddfundamental.airport;

import com.temmy.fms.airport.Passenger;
import com.temmy.fms.mileage.Mileage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;



public class BonusPolicy {

    private Passenger mike;
    private Passenger john;
    private Mileage mileage;

    @Given("^we have a usual passenger with a mileage$")
    public void weHaveAUsualPassengerWithAMileage() {
        mike = new Passenger("Mike", false);
        mileage = new Mileage();
    }

    @When("^the usual passenger travels <mileage(\\d+)> and <mileage(\\d+)> and <mileage(\\d+)>$")
    public void theUsualPassengerTravelsMileageAndAnd(int mileage1, int mileage2, int mileage3) {

        mileage.addMileage(mike, mileage1);
        mileage.addMileage(mike, mileage2);
        mileage.addMileage(mike, mileage3);
    }


    @Then("^the bonus points of the usual passenger should be (\\d+)$")
    public void theBonusPointsOfTheUsualPassengerShouldBe(int points) {
        mileage.calculateGivenPoints();
        Assertions.assertEquals(points, mileage.getPassengersPointsMap().get(mike).intValue());
    }


    @Given("^we have a VIP passenger with a mileage$")
    public void weHaveAVIPPassengerWithAMileage() {

        john = new Passenger("John", true);
        mileage = new Mileage();

    }

    @When("^the VIP passenger travels <mileage(\\d+)> and <mileage(\\d+)> and <mileage(\\d+)>$")
    public void theVIPPassengerTravelsMileageAndMileageAndMileage(int mileage1, int mileage2, int mileage3) {
        mileage.addMileage(john, mileage1);
        mileage.addMileage(john, mileage2);
        mileage.addMileage(john, mileage3);
    }

    @Then("^the bonus points of the VIP passenger should be <points>$")
    public void theBonusPointsOfTheVIPPassengerShouldBePoints(int points) {

        mileage.calculateGivenPoints();
        Assertions.assertEquals(points, mileage.getPassengersPointsMap().get(john).intValue());

    }


}
