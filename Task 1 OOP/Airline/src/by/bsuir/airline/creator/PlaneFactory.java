package by.bsuir.airline.creator;

import by.bsuir.airline.entity.PlaneType;
import by.bsuir.airline.exception.CreatorException;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class PlaneFactory {
    public static PlaneCreator getPlaneCreator(String type) throws CreatorException{
        PlaneType planeType = PlaneType.valueOf(type.toUpperCase());
        switch(planeType) {
            case PASSENGER: return new PassengerPlaneCreator();
            case CARGO: return new CargoPlaneCreator();
            case PRIVATE: return new PrivatePlaneCreator();
            default: throw new CreatorException("Invalid plane type");
        }
    }
}
