package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MoreThanTwoHoursGroundTimeFilter implements Filter {
    /**
     * Метод, возвращает список перелетов, где общее время, проведённое на земле, превышает два часа
     */
    @Override
    public List<Flight> filter(List<Flight> list) {
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

