package by.bsuir.airline.actions;

import by.bsuir.airline.actions.comparator.FlightRangeComparator;
import by.bsuir.airline.entity.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class SortPlanes {
    public static List<Plane> sortByFlightRange(List<Plane> planes) {
        ArrayList<Plane> sortedPlanes = new ArrayList<Plane>(planes);
        Collections.sort(sortedPlanes, new FlightRangeComparator());
        return sortedPlanes;
    }
}
