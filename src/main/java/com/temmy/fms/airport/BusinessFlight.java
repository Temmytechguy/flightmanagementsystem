package com.temmy.fms.airport;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessFlight extends Flight{


    public BusinessFlight(String id) {
        super(id);



    }

    @Override
    public String getId() {
        return super.getId();
    }


    @Override
    public boolean addPassenger(Passenger passengerToAdd) {
        if (passengerToAdd.isVip()) {
            passengersSet.add(passengerToAdd);
            return true;
        } else {
            return false;
        }
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
