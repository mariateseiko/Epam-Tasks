package by.bsuir.task2.entity;

public class ParkingPlace {
    private int parkingPlaceId;

    public ParkingPlace(int parkingPlaceId) {
        this.parkingPlaceId = parkingPlaceId;
    }

    public int getParkingPlaceId() {
        return parkingPlaceId;
    }

    @Override
    public String toString() {
        return "Parking place#" + parkingPlaceId;
    }
}
