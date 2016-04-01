package by.bsuir.airline.entity;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class CargoPlane extends Plane {
    private int liftingCapacity;

    public CargoPlane(String name, int fuelConsumptionPerHour, int flightRange, int liftingCapacity, int id) {
        super(name, fuelConsumptionPerHour, flightRange, id);
        this.liftingCapacity = liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        CargoPlane plane = (CargoPlane)obj;
        if (plane.getLiftingCapacity() != liftingCapacity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.append("; lifting capacity: ").append(liftingCapacity)
                .toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + liftingCapacity;
    }
}
