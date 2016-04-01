package by.bsuir.task4.parser;

import by.bsuir.task4.entity.Component;
import by.bsuir.task4.entity.Device;
import by.bsuir.task4.entity.Peripheral;
import by.bsuir.task4.exception.XMLParserException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDevicesBuilder {
    protected Set<Component> components;
    protected Set<Peripheral> peripherals;
    public AbstractDevicesBuilder() {
        components = new HashSet<>();
        peripherals = new HashSet<>();
    }

    public Set<Component> getComponents() { return components; }
    public Set<Peripheral> getPeripherals() { return peripherals; }

    abstract public void buildSetDevices(String fileName) throws XMLParserException;
}
