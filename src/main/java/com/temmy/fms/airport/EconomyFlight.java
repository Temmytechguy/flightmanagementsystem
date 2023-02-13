package com.temmy.fms.airport;

import java.util.*;
import java.util.stream.Collectors;

public class EconomyFlight  extends Flight{



    public EconomyFlight(String id) {
        super(id);



        }



    @Override
    public boolean addPassenger(Passenger passengerToAdd) {

        return  passengersSet.add(passengerToAdd);

    }

    @Override
    public boolean removePassenger(Passenger passengerToRemove) {

        if(passengerToRemove.isVip())
        {
            return false;
        }
        else{
            List<Passenger> remainingPassengers = passengersSet.stream()
                    .filter(p -> !p.equals(passengerToRemove))
                    .collect(Collectors.toList());

            if (remainingPassengers.size() == passengersSet.size()) {
                return false;
            } else
            {
                passengersSet.clear();
                passengersSet.addAll(remainingPassengers);
                return true;
            }

        }

    }
}
