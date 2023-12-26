package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Filter filter = new FilterImpl();
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Show all flights");
        System.out.println(flights);
        System.out.println();

        System.out.println("Departure to the current point in time.");
        System.out.println(filter.departingInThePastFilter(flights));
        System.out.println();

        System.out.println("Segments with an arrival date earlier than the departure date.");
        System.out.println(filter.arrivalBeforeDepartureFilter(flights));
        System.out.println();

        System.out.println("Flights where the total time spent on the ground is more than two hours");
        System.out.println(filter.moreThanTwoHoursGroundTimeFilter(flights));
        System.out.println();
    }
}