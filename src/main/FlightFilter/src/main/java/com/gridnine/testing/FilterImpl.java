package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация интерфейса {@link Filter}
 */
public class FilterImpl implements Filter {
    /**
     * Метод возвращает список полетов, время вылета которых назначено до текущего момента
     */
    @Override
    public List<Flight> departingInThePastFilter(List<Flight> list) {

        return list.stream().filter(flight -> flight.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))).collect(Collectors.toList());
    }

    /**
     * Метод, возвращает список полетов у которых время прилета раньше времени вылета
     */
    @Override
    public List<Flight> arrivalBeforeDepartureFilter(List<Flight> list) {

        return list.stream().filter(flight -> flight.getSegments().stream().anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))).collect(Collectors.toList());
    }

    /**
     * Метод, возвращает список перелетов, где общее время, проведённое на земле, превышает два часа
     */
    @Override
    public List<Flight> moreThanTwoHoursGroundTimeFilter(List<Flight> list) {

        Duration duration;
        long maxTimeOnGround = 0;
        List<Flight> result = new ArrayList<>();

        for (Flight flight : list) {
            List<Segment> segmentList = flight.getSegments();

            if (segmentList.size() < 2) {
                continue;
            }

            for (int i = 0; i < segmentList.size() - 1; i++) {
                duration = Duration.between(segmentList.get(i).getArrivalDate(), segmentList.get(i + 1).getDepartureDate());
                maxTimeOnGround += duration.toMinutes();
                if (maxTimeOnGround > 120) {
                    result.add(flight);
                }
            }
            maxTimeOnGround = 0;
        }

        return result;
    }
}
