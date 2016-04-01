package by.bsuir.task2.creator.parser;

import by.bsuir.task2.exception.ParkingNetworkParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParkingNetworkParser {
    private JSONObject parkingNetwork;
    private JSONParser parser;

    public ParkingNetworkParser() {
        parser = new JSONParser();
    }

    public void parseParkingNetworkFromJson(String file) throws ParkingNetworkParserException {
        try {
            Object obj = parser.parse(new FileReader(file));
            parkingNetwork = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            throw new ParkingNetworkParserException("File " + file + "was not found", e);
        } catch (IOException e) {
            throw new ParkingNetworkParserException("Error reading " + file + " file", e);
        } catch (ParseException e) {
            throw new ParkingNetworkParserException("Error parsing " + file + " file", e);
        }
    }

    public String getParkingNetworkName() throws ParkingNetworkParserException {
        if (parkingNetwork != null) {
            return  (String) parkingNetwork.get("name");
        } else {
            throw new ParkingNetworkParserException("JSON object doesn't exist");
        }
    }

    public JSONArray getParkings() throws ParkingNetworkParserException {
        if (parkingNetwork != null) {
            return  (JSONArray) parkingNetwork.get("parkings");
        } else {
            throw new ParkingNetworkParserException("JSON array doesn't exist");
        }
    }
}