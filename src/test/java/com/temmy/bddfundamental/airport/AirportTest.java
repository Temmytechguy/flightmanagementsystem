package com.temmy.bddfundamental.airport;




import com.temmy.fms.airport.BusinessFlight;
import com.temmy.fms.airport.EconomyFlight;
import com.temmy.fms.airport.Flight;
import com.temmy.fms.airport.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {
         Flight economyFlight;
         Passenger mike;
         Passenger john;

        @BeforeEach
        void setUp()
        {
            economyFlight = new EconomyFlight("1");
             mike = new Passenger("Mike", false);
             john= new Passenger("John", true);
        }

        @DisplayName("when we have a usual passenger")
        @Nested
         class UsualPassenger
        {
            @Test
            @DisplayName("Then you can add him and remove him from economy class")
            public void testAdd()
            {

                assertAll("verify all conditions for a usual passenger on an economy class",
                        () ->assertEquals("1", economyFlight.getId()),
                        () ->assertEquals(true, economyFlight.addPassenger(mike)),
                        () ->assertEquals(1, economyFlight.getPassengersSet().size()),
                        () ->assertEquals("Mike", economyFlight.getPassengersSet().stream().findAny().get().getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () ->assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }

        }

        @DisplayName("When we have a vip passenger")
        @Nested
         class vipPassenger{
            @Test
            @DisplayName("Then you can add him but cannot remove him from the economy class")
            public void testAddAndRemove()
            {
                assertAll("verify all conditions for a vip on an economy class",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("John", economyFlight.getPassengersSet().stream().findAny().get().getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }


            }

        }



    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest
    {
         Flight businessFlight;
         Passenger mike;
         Passenger john;


        @BeforeEach
        void setUp()
        {
            businessFlight = new BusinessFlight("1");
             mike = new Passenger("Mike", false);
             john = new Passenger("John", true);

        }

        @DisplayName("when we have a usual passenger")
        @Nested
        class UsualPassenger
        {
            @Test
            @DisplayName("Then you cannot add him to business flight")
            public void testAdd()
            {
                assertAll("verify all conditions is met not to add usual passenger to business flight",
                        ()-> assertEquals(false, businessFlight.addPassenger(mike)),
                        ()->assertEquals(0, businessFlight.getPassengersSet().size()),
                        ()->assertEquals(false, businessFlight.removePassenger(mike)),
                        ()->assertEquals(0, businessFlight.getPassengersSet().size()));

            }

        }

        @DisplayName("when we have a Vip passenger")
        @Nested
        class VipPassenger{

            @Test
            @DisplayName("Then you can add him and not remove from business flight")
            public void testAddAndNotRemove()
            {

                assertAll("verify all conditons is met to add vip to business class",
                        () ->  assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () ->  assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                        );

            }

        }



    }

}



