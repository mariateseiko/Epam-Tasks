package by.bsuir.airline.actions;

import by.bsuir.airline.entity.CargoPlane;
import by.bsuir.airline.entity.PassengerPlane;
import by.bsuir.airline.entity.Plane;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Maria Teseiko on 25.11.2015.
 */
public class PlanesStats {
    static final Logger LOG = Logger.getLogger(PlanesStats.class);
    public static int countPassengerCapacity(List<Plane> planes) {
        int capacity = 0;
        for (Plane plane: planes) {
            if (plane instanceof PassengerPlane) {
                capacity += ((PassengerPlane) plane).getPassengerCapacity();
            }
        }
        LOG.debug("Passenger Capacity: " + capacity);
        return capacity;
    }

    public static int countLiftingCapacity(List<Plane> planes) {
        int capacity = 0;
        for (Plane plane: planes) {
            if (plane instanceof CargoPlane) {
                capacity += ((CargoPlane) plane).getLiftingCapacity();
            }
        }
        LOG.debug("Lifting Capacity: " + capacity);
        return capacity;
    }
}
