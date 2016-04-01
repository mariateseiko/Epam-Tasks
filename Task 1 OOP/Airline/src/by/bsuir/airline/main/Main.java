package by.bsuir.airline.main;

import by.bsuir.airline.actions.FindPlanes;
import by.bsuir.airline.actions.SortPlanes;
import by.bsuir.airline.actions.PlanesStats;
import by.bsuir.airline.creator.AirlineCreator;
import by.bsuir.airline.entity.Airline;
import by.bsuir.airline.exception.AirlineParserException;
import by.bsuir.airline.exception.CreatorException;
import by.bsuir.airline.exception.ReportException;
import by.bsuir.airline.report.PlaneReport;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class Main {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static final Logger LOG = Logger.getLogger(Main.class);
    static final String JSON_FILE = "resources\\airline.json";
    static final String REPORT_FILE = "reports\\report.txt";
    public static void main(String[] args) {
        try {
            Airline airline = AirlineCreator.createAirlineFromJson(JSON_FILE);

            PlaneReport.print("Planes sorted by flight range (ascending):",
                    SortPlanes.sortByFlightRange(airline.getPlanes()), REPORT_FILE);
            PlaneReport.print("Planes found by fuel consumption in range " + 2000 + "-" + 7000 + ":",
                    FindPlanes.findPlanesByFuelConsumptionRange(airline.getPlanes(), 2000, 7000), REPORT_FILE);
            PlaneReport.print("Total cargo lifting capacity",
                    PlanesStats.countLiftingCapacity(airline.getPlanes()), REPORT_FILE);
            PlaneReport.print("Total passenger lifting capacity",
                    PlanesStats.countPassengerCapacity(airline.getPlanes()), REPORT_FILE);

        } catch (CreatorException | ReportException | AirlineParserException e) {
            LOG.error(e.getMessage());
        }
    }
}
