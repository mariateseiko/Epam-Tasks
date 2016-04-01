package by.bsuir.airline.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */
public class Airline {
    private String name;
    private ArrayList<Plane> planes = new ArrayList<>();

    public Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public boolean removePlane(Plane plane) {
        Iterator<Plane> iterator = planes.iterator();
        while (iterator.hasNext()) {
            Plane currentPlane = iterator.next();
            if (currentPlane.equals(plane)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public int planesCount() {
        return planes.size();
    }

    public List<Plane> getPlanes() {
        return Collections.unmodifiableList(planes);
    }
}
