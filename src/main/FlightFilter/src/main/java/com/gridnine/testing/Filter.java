package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс Filter в котором отображены фильтры для полетов
 */
public interface Filter {
    List<Flight> filter (List<Flight> list);
}
