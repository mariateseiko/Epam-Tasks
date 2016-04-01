package by.bsuir.airline.entity;

/**
 * Created by Maria Teseiko on 26.11.2015.
 */
public class PrivatePlane extends PassengerPlane {
    private String owner;
    private int numberOfEngines;

    public PrivatePlane(String name, int fuelConsumptionPerHour, int flightRange, int capacity, String owner,
                        int numberOfEngines, int id) {
        super(name, fuelConsumptionPerHour, flightRange, capacity, id);
        this.owner = owner;
        this.numberOfEngines = numberOfEngines;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.append("; owner: ").append(owner)
                .append("; number of engines: " + numberOfEngines)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PrivatePlane plane = (PrivatePlane)obj;
        if (plane.getNumberOfEngines() != numberOfEngines) {
            return false;
        }
        if (owner == null) {
            if (plane.getOwner() != null) {
                return false;
            }
        } else if (!owner.equals(plane.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + ((owner == null) ? 0 : owner.hashCode());
        result = 37 * result + numberOfEngines;
        return result;
    }
}
