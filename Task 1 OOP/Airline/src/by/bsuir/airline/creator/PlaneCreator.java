package by.bsuir.airline.creator;

import by.bsuir.airline.entity.Plane;
import org.json.simple.JSONObject;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public abstract class PlaneCreator {
    public abstract Plane createPlane(JSONObject obj);
}
