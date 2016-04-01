package by.bsuir.task2.creator;

import by.bsuir.task2.creator.parser.ParkingNetworkParser;
import by.bsuir.task2.entity.Parking;
import by.bsuir.task2.exception.ParkingNetworkParserException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;

public class ParkingNetworkCreator {
    private String name;
    private ArrayList<Parking> parkingList = new ArrayList<>();
    private String path;

    public ParkingNetworkCreator(String path) {
        this.path = path;
    }

    public void createParkingNetworkFromJson() throws ParkingNetworkParserException {
        ParkingNetworkParser parkingNetworkParser = new ParkingNetworkParser();
        parkingNetworkParser.parseParkingNetworkFromJson(path);
        name = parkingNetworkParser.getParkingNetworkName();
        JSONArray parkings = parkingNetworkParser.getParkings();
        Iterator<JSONObject> iterator = parkings.iterator();
        while (iterator.hasNext()) {
            JSONObject parking = iterator.next();
            parkingList.add(ParkingCreator.createParking(parking));
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Parking> getParkingList() {
        return parkingList;
    }
}
