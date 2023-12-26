package com.gridnine.testing;

import java.util.List;
/**
 * Интерфейс Filter в котором отображены фильтры для полетов
 */
public interface Filter {
    List<Flight> departingInThePastFilter(List<Flight> list);

    List<Flight> arrivalBeforeDepartureFilter(List<Flight> list);

    List<Flight> moreThanTwoHoursGroundTimeFilter(List<Flight> list);
}
