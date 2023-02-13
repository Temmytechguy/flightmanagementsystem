package com.temmy.fms.airport;

import java.util.List;
import java.util.stream.Collectors;

public class PremiumFlight extends Flight{



    public PremiumFlight(String id) {
        super(id);

    }

    @Override
    public boolean addPassenger(Passenger passengerToAdd) {
        if(passengerToAdd.isVip())
        {
            return passengersSet.add(passengerToAdd);
        }

            return false;


    }

    @Override
    public boolean removePassenger(Passenger passengerToRemove) {
        if (passengerToRemove.isVip()) {

            return passengersSet.remove(passengerToRemove);
        }
        return false;
    }
}
