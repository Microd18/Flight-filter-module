package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements Filter {
    /**
     * Метод возвращает список полетов у которых время прилета раньше времени вылета
     */
    @Override
    public List<Flight> filter(List<Flight> list) {
        return list.stream().filter(flight -> flight
                        .getSegments()
                        .stream()
                        .anyMatch(segment -> segment
                                .getArrivalDate()
                                .isBefore(segment
                                        .getDepartureDate())))
                .collect(Collectors.toList());
    }
}
