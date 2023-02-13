package com.temmy.fms.mileage;

import com.temmy.fms.airport.Passenger;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {

    private static List<Integer> createMileageList(Mileage mileage)
    {
        List<Integer> mileageList = new ArrayList<>();

        for(Passenger passenger: mileage.getPassengersMileageListMap().keySet())
        {
            mileageList.addAll(mileage.getPassengersMileageListMap().get(passenger));
        }

        return mileageList;
    }

    public static  int totalDistance(Mileage mileage)
    {
        List<Integer> mileageList = createMileageList(mileage);
        return mileageList.stream().mapToInt(Integer::intValue).sum();

    }
}
