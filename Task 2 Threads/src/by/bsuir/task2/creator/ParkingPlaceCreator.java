package by.bsuir.task2.creator;

import by.bsuir.task2.entity.ParkingPlace;
import org.json.simple.JSONObject;

/**
 * Created by Maria Teseiko on 07.12.2015.
 */
public class ParkingPlaceCreator {
    public static ParkingPlace createParkingPlace(JSONObject jsonObject) {
        int id = ((Long)jsonObject.get("id")).intValue();
        ParkingPlace place = new ParkingPlace(id);
        return place;
    }
}
