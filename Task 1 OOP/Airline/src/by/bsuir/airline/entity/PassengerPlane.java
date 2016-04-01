package by.bsuir.airline.entity;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class PassengerPlane extends Plane {
    private int passengerCapacity;

    public PassengerPlane(String name, int fuelConsumptionPerHour, int flightRange, int passengerCapacity, int id) {
        super(name, fuelConsumptionPerHour, flightRange, id);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PassengerPlane plane = (PassengerPlane)obj;
        if (plane.getPassengerCapacity() != passengerCapacity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.append("; passengerCapacity: ").append(passengerCapacity)
                .toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + passengerCapacity;
    }
}
