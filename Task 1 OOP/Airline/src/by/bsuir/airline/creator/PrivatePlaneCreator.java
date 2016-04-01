package by.bsuir.airline.creator;

import by.bsuir.airline.entity.Plane;
import by.bsuir.airline.entity.PrivatePlane;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class PrivatePlaneCreator extends PlaneCreator {
    static final Logger LOG = Logger.getLogger(PrivatePlaneCreator.class);
    @Override
    public Plane createPlane(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        int fuelConsumptionPerHour = ((Long)jsonObject.get("fuelConsumptionPerHour")).intValue();
        int flightRange = ((Long)jsonObject.get("flightRange")).intValue();
        int capacity = ((Long)jsonObject.get("capacity")).intValue();
        String owner = (String) jsonObject.get("owner");
        int numberOfEngines = ((Long)jsonObject.get("numberOfEngines")).intValue();
        int id = ((Long)jsonObject.get("id")).intValue();
        PrivatePlane plane = new PrivatePlane(name, fuelConsumptionPerHour, flightRange, capacity, owner, numberOfEngines, id);
        LOG.debug("New PrivatePlane [" + plane + "] created");
        return plane;
    }
}
