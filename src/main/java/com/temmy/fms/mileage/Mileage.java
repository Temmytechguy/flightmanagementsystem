package com.temmy.fms.mileage;

import com.temmy.fms.airport.Passenger;
import cucumber.api.java.hu.Ha;

import java.util.*;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMileageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointMap = new HashMap<>();

    public Map<Passenger, List<Integer>> getPassengersMileageListMap() {
        return passengersMileageListMap;
    }

    private Map<Passenger, List<Integer>> passengersMileageListMap = new HashMap<>();

    public void addMileageToList(Passenger passenger, int miles)
    {
        if (!passengersMileageListMap.containsKey(passenger)) {
            passengersMileageListMap.put(passenger, new ArrayList<>());
        }
        passengersMileageListMap.get(passenger).add(miles);
    }
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
