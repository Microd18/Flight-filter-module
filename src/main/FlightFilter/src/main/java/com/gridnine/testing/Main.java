package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println(new DepartingInThePastFilter().filter(flights));
        System.out.println();
        System.out.println(new ArrivalBeforeDepartureFilter().filter(flights));
        System.out.println();
        System.out.println(new MoreThanTwoHoursGroundTimeFilter().filter(flights));
    }
}