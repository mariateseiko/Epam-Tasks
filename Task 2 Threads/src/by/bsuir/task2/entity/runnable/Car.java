package by.bsuir.task2.entity.runnable;

import by.bsuir.task2.entity.Parking;
import by.bsuir.task2.entity.ParkingNetwork;
import by.bsuir.task2.entity.ParkingPlace;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    final long WAITING_TIME;
    private int carId;
    private boolean isFinished;
    static final Logger LOG = Logger.getLogger(Car.class);

    public Car(int carId, long waitingTime) {
        this.carId = carId;
        WAITING_TIME = waitingTime;
    }

    @Override
    public void run() {
        Parking parking;
        while (!isFinished) {
            try {
                parking = ParkingNetwork.getInstance().takeParking();
                ParkingPlace place = parking.takeParkingPlace(WAITING_TIME);
                if (place != null) {
                    LOG.info(this + " got " + place + " from " + parking);
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));
                    parking.leaveParkingPlace(place);
                    LOG.info(this + " left " + place + " at " + parking);
                    isFinished = true;
                } else {
                    LOG.info(this + " waiting for a parking place at " + parking + " timed out");
                    LOG.info(this + " looking for a new parking");
                }
            } catch(InterruptedException e){
                LOG.error("Error occurred while " + this + " was at the parking lot");
            }
        }
    }

    public int getCarId() {
        return carId;
    }
    
    @Override
    public String toString() {
        return "Car#" + carId;
    }
}
