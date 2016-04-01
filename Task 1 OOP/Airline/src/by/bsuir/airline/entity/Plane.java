package by.bsuir.airline.entity;

public abstract class Plane {
    private String name;
    private int fuelConsumptionPerHour;
    private int flightRange;
    private int id;

    public Plane(String name, int fuelConsumptionPerHour, int flightRange, int id) {
        this.name = name;
        this.fuelConsumptionPerHour = fuelConsumptionPerHour;
        this.flightRange = flightRange;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuelConsumptionPerHour() {
        return fuelConsumptionPerHour;
    }

    public void setFuelConsumptionPerHour(int fuelConsumptionPerHour) {
        this.fuelConsumptionPerHour = fuelConsumptionPerHour;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange() {
        this.flightRange = flightRange;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Plane plane = (Plane)obj;

        if (fuelConsumptionPerHour != plane.getFuelConsumptionPerHour()) {
            return false;
        }
        if (flightRange != plane.getFlightRange()) {
            return false;
        }
        if (id != plane.getId()) {
            return false;
        }
        if (name == null) {
            if (plane.getName() != null) {
                return false;
            }
        } else if (!name.equals(plane.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("id: ").append(id)
                .append("; name: ").append(name)
                .append("; fuel consumption (ton/hour): ").append(fuelConsumptionPerHour)
                .append("; flight range (km): ").append(flightRange)
                .toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 37 + fuelConsumptionPerHour;
        result = result * 37 + flightRange;
        result = result * 37 + id;
        result = result * 37 +  ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
