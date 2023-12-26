package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartingInThePastFilter implements Filter {
    /**
     * Метод возвращает список полетов, время вылета которых назначено до текущего момента
     */
    @Override
    public List<Flight> filter(List<Flight> list) {
        return list.stream().filter(flight -> flight
                .getSegments()
                .stream()
                .anyMatch(segment -> segment
                        .getDepartureDate()
                        .isBefore(LocalDateTime.now()))).collect(Collectors.toList());
    }
}
