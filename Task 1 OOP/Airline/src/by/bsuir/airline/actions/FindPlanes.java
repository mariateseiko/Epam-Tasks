package by.bsuir.airline.actions;

import by.bsuir.airline.entity.Plane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class FindPlanes {
    public static List<Plane> findPlanesByFuelConsumptionRange(List<Plane> planes, int min, int max) {
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane plane: planes) {
            if ((plane.getFuelConsumptionPerHour() >= min) && (plane.getFuelConsumptionPerHour() <= max)) {
                foundPlanes.add(plane);
            }
        }
        return foundPlanes;
    }
}
