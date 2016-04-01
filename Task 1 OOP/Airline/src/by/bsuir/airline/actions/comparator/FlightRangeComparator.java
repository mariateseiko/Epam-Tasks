package by.bsuir.airline.actions.comparator;

import by.bsuir.airline.entity.Plane;

import java.util.Comparator;

/**
 * Created by Maria Teseiko on 25.11.2015.
 */
public class FlightRangeComparator implements Comparator<Plane> {
    public int compare(Plane one, Plane two) {
        return one.getFlightRange() - two.getFlightRange();
    }
}
