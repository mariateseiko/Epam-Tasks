package by.bsuir.task2.creator;

import by.bsuir.task2.entity.Parking;
import by.bsuir.task2.entity.ParkingPlace;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class ParkingCreator {
    public static Parking createParking(JSONObject jsonObject) {
        int id = ((Long)jsonObject.get("id")).intValue();

        LinkedList<ParkingPlace> places = new LinkedList<>();
        JSONArray parkingPlaces = (JSONArray)jsonObject.get("parkingPlaces");

        Iterator<JSONObject> iterator = parkingPlaces.iterator();
        while (iterator.hasNext()) {
            JSONObject parkingPlace = iterator.next();
            places.add(ParkingPlaceCreator.createParkingPlace(parkingPlace));
        }

        Parking parking = new Parking(id, places);
        return parking;
    }


}
