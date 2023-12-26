# <u>Фильтр авиаперелётов</u>
<hr>

Согласно техническому заданию от компании SkyPro, необходимо написать модуль, который будет заниматься фильтрацией набора перелетов согласно различным правилам

**Проект включает в себя систему, которая обрабатывает авиаперелёты:**
```
Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками.
```
Это значит, что перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами.
```
Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.
```

Задача — написать модуль, который будет заниматься фильтрацией набора перелётов согласно различным правилам.

- Правил фильтрации может быть очень много.
- Наборы перелётов также могут быть очень большими.
- Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.

Фильтры которые необходимо реализовать:

- Вылет до текущего момента времени.
- Сегменты с датой прилёта раньше даты вылета.
- Перелеты, где общее время, проведённое на земле, превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).

Структура модуля:

- ```class Segment``` предназначен для хранения информации о перелете из одной точки в другую.
- ```class Flight``` - главный класс, который содержит список сегментов;
- ```class FlightBuilder``` - класс для получения тестовых образцов;
- ```interface Filter``` - интерфейс содержит метод для фильтрации информации о перелете;
- ```class ArrivalBeforeDepartureFilter``` - реализует интерфейс Filter. Возвращает список полетов у которых время прилета раньше времени вылета
- ```class DepartingInThePastFilter``` - реализует интерфейс Filter. Возвращает список полетов, время вылета которых назначено до текущего момента
- ```class MoreThanTwoHoursGroundTimeFilter``` - реализует интерфейс Filter. Возвращает список перелетов, где общее время, проведённое на земле, превышает два часа

Модуль покрыт Unit Tests.


### Инструменты разработки:
```
* IntelliJ IDEA
* Java 21
* Сборка с помощью org.apache.maven
```


