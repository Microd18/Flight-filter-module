package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterImplTest {

    Filter filter = new FilterImpl();
    public List<Flight> list = FlightBuilder.createFlights();

    @Test
    public void test1() {
        List<Flight> list2 = filter.departingInThePastFilter(list);

        assertEquals(list2.get(0), list.get(2));
        assertEquals(list2.get(0).toString(), list.get(2).toString());

    }

    @Test
    public void test2() {
        List<Flight> list2 = filter.arrivalBeforeDepartureFilter(list);

        assertEquals(list2.get(0), list.get(3));

    }

    @Test
    public void test3() {
        List<Flight> list2 = filter.moreThanTwoHoursGroundTimeFilter(list);

        assertEquals(list2.get(0), list.get(4));
        assertEquals(list2.get(1), list.get(5));

    }

}