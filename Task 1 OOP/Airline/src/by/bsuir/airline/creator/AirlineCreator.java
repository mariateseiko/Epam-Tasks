package by.bsuir.airline.creator;

import by.bsuir.airline.creator.parser.AirlineParser;
import by.bsuir.airline.entity.Airline;
import by.bsuir.airline.exception.CreatorException;
import by.bsuir.airline.exception.AirlineParserException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Iterator;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class AirlineCreator {
    static final Logger LOG = Logger.getLogger(AirlineCreator.class);

    public static Airline createAirlineFromJson(String file) throws CreatorException, AirlineParserException {
        AirlineParser airlineParser = new AirlineParser();
        airlineParser.parseAirlineFromJson(file);
        Airline airline = new Airline(airlineParser.getAirlineName());

        JSONArray airlinePlanes = airlineParser.getPlanes();
        Iterator<JSONObject> iterator = airlinePlanes.iterator();
        while (iterator.hasNext()) {
            JSONObject plane = iterator.next();
            String type = (String) plane.get("type");
            airline.addPlane(PlaneFactory.getPlaneCreator(type).createPlane(plane));
        }

        LOG.debug("New airline " + airline.getName()+ " with " + airline.planesCount() + " planes created");
        return airline;
    }
}
