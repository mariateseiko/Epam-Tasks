package by.bsuir.task4.parser;

import by.bsuir.task4.entity.Component;
import by.bsuir.task4.entity.Device;
import by.bsuir.task4.entity.Peripheral;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class DeviceHandler extends DefaultHandler {
    private Set<Component> components = new HashSet<>();
    private Set<Peripheral> peripherals = new HashSet<>();
    private Device current;
    private DeviceEnum currentEnum;
    private EnumSet<DeviceEnum> withText;

    public DeviceHandler() {
        withText = EnumSet.range(DeviceEnum.PRICE, DeviceEnum.POWER);
    }

    public Set<Component> getComponents() { return components; }
    public Set<Peripheral> getPeripherals() { return peripherals; }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (DeviceEnum.PERIPHERAL.getValue().equals(localName)) {
            current = new Peripheral();
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            } else {
                current.setOrigin("Unknown");
            }
        }
         else if (DeviceEnum.COMPONENT.getValue().equals(localName)) {
            current = new Component();
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            } else {
                current.setOrigin("Unknown");
            }
        } else {
            DeviceEnum temp = DeviceEnum.getEnum(localName);
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (DeviceEnum.PERIPHERAL.getValue().equals(localName)) {
            peripherals.add((Peripheral)current);
        } else if (DeviceEnum.COMPONENT.getValue().equals(localName)) {
            components.add((Component)current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case PRICE:
                    current.setPrice(Integer.parseInt(s));
                    break;
                case DEVICE_TYPE:
                    current.setDeviceType(s);
                    break;
                case PLUG_AND_PLAY:
                    ((Peripheral)current).setPlugAndPlay(Boolean.parseBoolean(s));
                    break;
                case CRITICAL:
                    ((Component)current).setCritical(Boolean.parseBoolean(s));
                    break;
                case GROUP:
                    ((Peripheral)current).getType().setGroup(s);
                    break;
                case PORT:
                    ((Peripheral)current).getType().setPort(s);
                    break;
                case COOLER:
                    ((Component)current).getType().setCooler(Boolean.parseBoolean(s));
                    break;
                case POWER:
                    ((Component)current).getType().setPower(Float.parseFloat(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
