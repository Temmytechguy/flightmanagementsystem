package com.temmy.bddfundamental.airport;


import com.temmy.fms.airport.EconomyFlight;
import com.temmy.fms.airport.Flight;
import com.temmy.fms.airport.Passenger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PassengersPolicy {

    private Flight economyFlight;
    private Passenger mike;

    @Given("there is an economy flight")
    public void givenThereIsAnEconomyFlight() {

        economyFlight = new EconomyFlight("1");

    }

    @When("we have a usual passenger")
    public void whenWeHaveAUsualPassenger() {
        mike = new Passenger("Mike", false);

    }

    @Then("you can add and remove him from an economy flight")
    public void thenYouCanAddAndRemoveHimFromAnEconomyFlight() {

        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                () -> assertTrue( new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike")),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengersSet().size()));
    }



}
