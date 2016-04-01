package by.bsuir.task2.entity;

import by.bsuir.task2.creator.ParkingNetworkCreator;
import by.bsuir.task2.exception.ParkingNetworkParserException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingNetwork {
    private String name;
    private ArrayList<Parking> parkings;
    private static AtomicBoolean isNull = new AtomicBoolean(true);
    private static ParkingNetwork instance;
    private static ReentrantLock lock = new ReentrantLock();

    static final Logger LOG = Logger.getLogger(ParkingNetwork.class);
    static final String PATH = "resources\\parkingNetwork.json";

    private ParkingNetwork() {
        try {
            ParkingNetworkCreator creator = new ParkingNetworkCreator(PATH);
            creator.createParkingNetworkFromJson();
            this.name = creator.getName();
            this.parkings = creator.getParkingList();
        } catch (ParkingNetworkParserException e) {
            LOG.error("Parking network creation failed due to parse error: " + e.getMessage());
        }
    }

    public static ParkingNetwork getInstance() {
        if (isNull.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ParkingNetwork();
                    isNull.set(false);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Parking takeParking() {
        return parkings.get(new Random().nextInt(parkings.size()));
    }

    public String getName() {
        return name;
    }
}
