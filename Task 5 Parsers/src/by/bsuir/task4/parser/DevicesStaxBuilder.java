package by.bsuir.task4.parser;

import by.bsuir.task4.entity.Component;
import by.bsuir.task4.entity.Device;
import by.bsuir.task4.entity.Peripheral;
import by.bsuir.task4.exception.XMLParserException;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DevicesStaxBuilder extends AbstractDevicesBuilder {
    private XMLInputFactory inputFactory;

    public DevicesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetDevices(String fileName) throws XMLParserException {
        XMLStreamReader reader = null;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (DeviceEnum.getEnum(name) == DeviceEnum.COMPONENT) {
                        Component component = buildComponent(reader);
                        components.add(component);
                    } else if (DeviceEnum.getEnum(name) == DeviceEnum.PERIPHERAL) {
                        Peripheral peripheral = buildPeripheral(reader);
                        peripherals.add(peripheral);
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new XMLParserException("StAX parser failed", e);
        } catch (FileNotFoundException e) {
            throw new XMLParserException("File " + fileName + " wasn't found", e);
        } catch (IOException e) {
            throw new XMLParserException("Error working with " + fileName, e);

        }
    }

    private Component buildComponent(XMLStreamReader reader) throws XMLStreamException {
        Component component = new Component();
        component.setName(reader.getAttributeValue(null, DeviceEnum.NAME.getValue()));
        String origin = reader.getAttributeValue(null, DeviceEnum.ORIGIN.getValue());
        if (origin != null) {
            component.setOrigin(origin);
        } else {
            component.setOrigin("Unknown");
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DeviceEnum.getEnum(name)) {
                        case CRITICAL:
                            component.setCritical(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case COMPONENT_TYPE:
                            component.setType(getXMLComponentType(reader));
                            break;
                        case DEVICE_TYPE:
                            component.setDeviceType(getXMLText(reader));
                            break;
                        case PRICE:
                            component.setPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DeviceEnum.getEnum(name) == DeviceEnum.COMPONENT) {
                        return component;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Component");
    }

    private Component.ComponentType getXMLComponentType(XMLStreamReader reader) throws XMLStreamException {
        Component.ComponentType componentType = new Component.ComponentType();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DeviceEnum.getEnum(name.toUpperCase())) {
                        case COOLER:
                            componentType.setCooler(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case POWER:
                            componentType.setPower(Float.parseFloat(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DeviceEnum.getEnum(name) == DeviceEnum.COMPONENT_TYPE){
                        return componentType;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Type");
    }

    private Peripheral buildPeripheral(XMLStreamReader reader) throws XMLStreamException {
        Peripheral peripheral = new Peripheral();
        peripheral.setName(reader.getAttributeValue(null, DeviceEnum.NAME.getValue()));
        String origin = reader.getAttributeValue(null, DeviceEnum.ORIGIN.getValue());
        if (origin != null) {
            peripheral.setOrigin(origin);
        } else {
            peripheral.setOrigin("Unknown");
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DeviceEnum.getEnum(name)) {
                        case PLUG_AND_PLAY:
                            peripheral.setPlugAndPlay(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case PERIPHERAL_TYPE:
                            peripheral.setType(getXMLPeripheralType(reader));
                            break;
                        case DEVICE_TYPE:
                            peripheral.setDeviceType(getXMLText(reader));
                            break;
                        case PRICE:
                            peripheral.setPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DeviceEnum.getEnum(name) == DeviceEnum.PERIPHERAL) {
                        return peripheral;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Peripheral");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Peripheral.PeripheralType getXMLPeripheralType(XMLStreamReader reader) throws XMLStreamException {
        Peripheral.PeripheralType peripheralType = new Peripheral.PeripheralType();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DeviceEnum.getEnum(name.toUpperCase())) {
                        case GROUP:
                            peripheralType.setGroup(getXMLText(reader));
                            break;
                        case PORT:
                            peripheralType.setPort(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DeviceEnum.getEnum(name) == DeviceEnum.PERIPHERAL_TYPE){
                        return peripheralType;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Type");
    }
}
