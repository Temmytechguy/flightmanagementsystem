package com.temmy.fms.mileage;

import com.temmy.fms.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMileageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointMap = new HashMap<>();

    public void addMileage(Passenger passenger, int miles)
    {
        if(passengersMileageMap.containsKey(passenger))
        {
            passengersMileageMap.put(passenger, passengersMileageMap.get(passenger) + miles);

        }
        else{
            passengersMileageMap.put(passenger, miles);
        }
    }

    public void calculateGivenPoints()
    {
        for(Passenger passenger: passengersMileageMap.keySet())
        {
            if(passenger.isVip()){
                passengersPointMap.put(passenger, passengersMileageMap.get(passenger) / VIP_FACTOR);

            }
            else{
                passengersPointMap.put(passenger, passengersMileageMap.get(passenger) / USUAL_FACTOR);
            }
        }
    }


    public Map<Passenger, Integer> getPassengersMileageMap() {
        return passengersMileageMap;
    }

    public Map<Passenger, Integer> getPassengersPointsMap() {
        return Collections.unmodifiableMap(passengersPointMap);
    }
}