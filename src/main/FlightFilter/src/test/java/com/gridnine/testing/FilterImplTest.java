package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FilterImplTest {

    public List<Flight> list = FlightBuilder.createFlights();

    @Test
    @DisplayName("Получение списка перелетов, время вылета которых назначено до текущего момента")
    public void DepartingInThePastTest() {

        List<Flight> list2 = new DepartingInThePastFilter().filter(list);

        assertEquals(list2.get(0), list.get(2));
        assertEquals(list2.get(0).toString(), list.get(2).toString());

    }

    @Test
    @DisplayName("Получение списка перелетов у которых время прилета раньше времени вылета")
    public void ArrivalBeforeDepartureTest() {
        List<Flight> list2 = new ArrivalBeforeDepartureFilter().filter(list);

        assertEquals(list2.get(0), list.get(3));
    }

    @Test
    @DisplayName("Получение списка перелетов, где общее время, проведённое на земле, превышает два часа")
    public void MoreThanTwoHoursGroundTimeTest() {
        List<Flight> list2 = new MoreThanTwoHoursGroundTimeFilter().filter(list);

        assertEquals(list2.get(0), list.get(4));
        assertEquals(list2.get(1), list.get(5));
    }

}