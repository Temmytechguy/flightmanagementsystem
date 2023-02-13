package com.temmy.bddfundamental;

import com.temmy.fms.airport.BusinessFlight;
import com.temmy.fms.airport.EconomyFlight;
import com.temmy.fms.airport.Passenger;
import com.temmy.fms.airport.PremiumFlight;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PassengerPolicy {

    private EconomyFlight economyFlight;
    private BusinessFlight businessFlight;
    private PremiumFlight premiumFlight;
    private Passenger mike;
    private Passenger john;

    @Given("^there is an economy flight$")
    public void thereIsAnEconomyFlight() {

        economyFlight = new EconomyFlight("1");

    }

    @When("^we have a usual passenger$")
    public void weHaveAUsualPassenger() {
        mike = new Passenger("Mike", false);
    }

    @Then("^You can add and remove him from an economy flight$")
    public void youCanAddAndRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                () -> assertTrue( new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike")),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengersSet().size()));
    }

    @And("^you cannot add a usual passenger to an economy flight more than once$")
    public void youCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() {

        for(int i = 0; i < 10; i++)
        {
            economyFlight.addPassenger(mike);
        }
        assertAll("Verify a usual passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                () -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
                () -> assertTrue( new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike")));

    }

    @When("^we have a VIP passenger$")
    public void weHaveAVIPPassenger() {

        john = new Passenger("John", true);
    }

    @Then("^You can add him but cannot remove him from an economy flight$")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {

    }

    @And("^you cannot add a VIP passenger to an economy flight more than once$")
    public void youCannotAddAVIPPassengerToAnEconomyFlightMoreThanOnce() {
        for(int i = 0; i < 10; i++)
        {
            economyFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                () -> assertTrue(economyFlight.getPassengersSet().contains(john)),
                () -> assertTrue( new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("John")));

    }

    @Given("^there is a business flight$")
    public void thereIsABusinessFlight() {

        businessFlight = new BusinessFlight("2");
    }

    @Then("^you cannot add or remove him from a business flight$")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {

        assertAll("Verify all conditions for a usual passenger and an business flight",
                () -> assertEquals(false, businessFlight.addPassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mike)),
                () -> assertEquals(0, businessFlight.getPassengersSet().size()));
    }

    @Then("^you can add him but cannot remove him from a business flight$")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger and an business flight",
                () -> assertEquals(true, businessFlight.addPassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(john)),
                () -> assertEquals(1, businessFlight.getPassengersSet().size()));
    }

    @And("^you cannot add a VIP passenger to a business flight more than once$")
    public void youCannotAddAVIPPassengerToABusinessFlightMoreThanOnce() {

        for(int i = 0; i < 10; i++)
        {
            businessFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an economy flight only once",
                () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                () -> assertTrue(businessFlight.getPassengersSet().contains(john)),
                () -> assertTrue( new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("John")));

    }

    @Given("^there is a premium flight$")
    public void thereIsAPremiumFlight() {

        premiumFlight = new PremiumFlight("3");
    }

    @Then("^you cannot add or remove him from a premium flight$")
    public void youCannotAddOrRemoveHimFromAPremiumFlight() {

        assertAll("Verify all conditions for a usual passenger and an premium flight",
                () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                () -> assertEquals(0, premiumFlight.getPassengersSet().size()));

    }

    @Then("^you can add or remove him from a premium flight$")
    public void youCanAddOrRemoveHimFromAPremiumFlight() {

        assertAll("Verify all conditions for a VIP passenger and an premium flight",
                () -> assertEquals(true, premiumFlight.addPassenger(john)),
                () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                () -> assertEquals(true, premiumFlight.removePassenger(john)),
                () -> assertEquals(0, premiumFlight.getPassengersSet().size()));

    }

    @And("^you cannot add a VIP passenger to a premium flight more than once$")
    public void youCannotAddAVIPPassengerToAPremiumFlightMoreThanOnce() {

        for(int i = 0; i < 10; i++)
        {
            premiumFlight.addPassenger(john);
        }
        assertAll("Verify a VIP passenger can be added to an economy flight only once",
                () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                () -> assertTrue(premiumFlight.getPassengersSet().contains(john)),
                () -> assertTrue( new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("John")));

    }
}
