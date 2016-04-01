package by.bsuir.airline.creator.parser;

import by.bsuir.airline.exception.AirlineParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class AirlineParser {
    private JSONObject airline;
    private JSONParser parser;

    public AirlineParser() {
        parser = new JSONParser();
    }
    public void parseAirlineFromJson(String file) throws AirlineParserException {
        try {
            Object obj = parser.parse(new FileReader(file));
            airline = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            throw new AirlineParserException("File " + file + "was not found", e);
        } catch (IOException e) {
            throw new AirlineParserException("Error reading " + file + " file", e);
        } catch (ParseException e) {
            throw new AirlineParserException("Error parsing " + file + " file", e);
        }
    }

    public String getAirlineName() throws AirlineParserException {
        if (airline != null) {
            return  (String) airline.get("name");
        } else {
            throw new AirlineParserException("Airline JSON object doesn't exist");
        }
    }

    public JSONArray getPlanes() throws AirlineParserException {
        if (airline != null) {
            return  (JSONArray) airline.get("planes");
        } else {
            throw new AirlineParserException("Airline JSON object doesn't exist");
        }
    }
}