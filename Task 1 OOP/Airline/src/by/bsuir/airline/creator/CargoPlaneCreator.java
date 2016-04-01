package by.bsuir.airline.creator;

import by.bsuir.airline.entity.CargoPlane;
import by.bsuir.airline.entity.Plane;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class CargoPlaneCreator extends PlaneCreator{
    static final Logger LOG = Logger.getLogger(CargoPlaneCreator.class);
    @Override
    public Plane createPlane(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        int fuelConsumptionPerHour = ((Long)jsonObject.get("fuelConsumptionPerHour")).intValue();
        int flightRange = ((Long)jsonObject.get("flightRange")).intValue();
        int capacity = ((Long)jsonObject.get("liftingCapacity")).intValue();
        int id = ((Long)jsonObject.get("id")).intValue();
        CargoPlane plane = new CargoPlane(name, fuelConsumptionPerHour, flightRange, capacity, id);
        LOG.debug("New CargoPlane [" + plane + "] created");
        return plane;
    }
}
