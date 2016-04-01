package by.bsuir.task2.entity;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    private int parkingId;
    private Queue<ParkingPlace> parkingPlaces;
    private ReentrantLock parkingLock = new ReentrantLock();
    private Condition freePlace = parkingLock.newCondition();

    static final Logger LOG = Logger.getLogger(Parking.class);

    public Parking(int parkingId, Queue<ParkingPlace> parkingPlaces) {
        this.parkingId = parkingId;
        this.parkingPlaces = new LinkedList<>(parkingPlaces);
    }

    public ParkingPlace takeParkingPlace(long waitingTime)  {
        ParkingPlace place = null;
        boolean hasAccess = false, isLocked = false;
        try {
            if (isLocked = parkingLock.tryLock(waitingTime, TimeUnit.MILLISECONDS)) {
                if (!parkingPlaces.isEmpty()) {
                    hasAccess = true;
                }
                else {
                    if (freePlace.await(waitingTime, TimeUnit.MILLISECONDS)) {
                        hasAccess = true;
                    }
                }

                if (hasAccess) {
                    place = parkingPlaces.poll();
                }
            }
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        } finally {
            if(isLocked) {
                parkingLock.unlock();
            }
        }
        return place;
    }

    public void leaveParkingPlace(ParkingPlace place) {
        parkingLock.lock();
        parkingPlaces.add(place);
        freePlace.signal();
        parkingLock.unlock();
    }

    public int getParkingId() {
        return parkingId;
    }

    @Override
    public String toString() {
        return "Parking#" + parkingId;
    }
}
