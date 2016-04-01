package by.bsuir.airline.creator;

import by.bsuir.airline.entity.PassengerPlane;
import by.bsuir.airline.entity.Plane;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * Created by Maria Teseiko on 25.11.2015.
 */
public class PassengerPlaneCreator extends PlaneCreator{
    static final Logger LOG = Logger.getLogger(PassengerPlaneCreator.class);
    @Override
    public Plane createPlane(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        int fuelConsumptionPerHour = ((Long)jsonObject.get("fuelConsumptionPerHour")).intValue();
        int flightRange = ((Long)jsonObject.get("flightRange")).intValue();
        int capacity = ((Long)jsonObject.get("capacity")).intValue();
        int id = ((Long)jsonObject.get("id")).intValue();
        PassengerPlane plane = new PassengerPlane(name, fuelConsumptionPerHour, flightRange, capacity, id);
        LOG.debug("New PassengerPlane [" + plane + "] created");
        return plane;
    }
}
