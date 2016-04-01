package by.bsuir.task4.parser;

import by.bsuir.task4.entity.Component;
import by.bsuir.task4.entity.Peripheral;
import by.bsuir.task4.exception.XMLParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DevicesDomBuilder extends AbstractDevicesBuilder {
    private DocumentBuilder docBuilder;
    public DevicesDomBuilder() throws XMLParserException{
        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XMLParserException("Failed to configure DOM parser", e);
        }
    }
    @Override
    public void buildSetDevices(String fileName) throws XMLParserException {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList peripheralList = root.getElementsByTagName(DeviceEnum.PERIPHERAL.getValue());
            NodeList componentList = root.getElementsByTagName(DeviceEnum.COMPONENT.getValue());

            for (int i = 0; i < peripheralList.getLength(); i++) {
                Element peripheralElement = (Element) peripheralList.item(i);
                Peripheral peripheral = buildPeripheral(peripheralElement);
                peripherals.add(peripheral);
            }

            for (int i = 0; i < componentList.getLength(); i++) {
                Element componentElement = (Element) componentList.item(i);
                Component component= buildComponent(componentElement);
                components.add(component);
            }
        } catch (IOException e) {
            throw new XMLParserException("File error or I/O error", e);
        } catch (SAXException e) {
            throw new XMLParserException("SAX parsing failed", e);
        }
    }

    private Peripheral buildPeripheral(Element peripheralElement) {
        Peripheral peripheral = new Peripheral();
        peripheral.setName(peripheralElement.getAttribute(DeviceEnum.NAME.getValue()));

        if (!peripheralElement.getAttribute(DeviceEnum.ORIGIN.getValue()).isEmpty()) {
            peripheral.setOrigin(peripheralElement.getAttribute(DeviceEnum.ORIGIN.getValue()));
        } else {
            peripheral.setOrigin("Unknown");
        }

        peripheral.setPlugAndPlay(Boolean.parseBoolean(getElementTextContent(
                peripheralElement, DeviceEnum.PLUG_AND_PLAY.getValue())));

        peripheral.setPrice(Integer.parseInt(getElementTextContent(
                peripheralElement, DeviceEnum.PRICE.getValue())));

        peripheral.setDeviceType(getElementTextContent(peripheralElement, DeviceEnum.DEVICE_TYPE.getValue()));

        Peripheral.PeripheralType type = peripheral.getType();
        Element typeElement = (Element) peripheralElement.getElementsByTagName(DeviceEnum.PERIPHERAL_TYPE.getValue()).item(0);
        type.setGroup(getElementTextContent(typeElement, DeviceEnum.GROUP.getValue()));
        type.setPort(getElementTextContent(typeElement, DeviceEnum.PORT.getValue()));

        return peripheral;
    }

    private Component buildComponent(Element componentElement) {
        Component component = new Component();
        component.setName(componentElement.getAttribute(DeviceEnum.NAME.getValue()));

        if (!componentElement.getAttribute(DeviceEnum.ORIGIN.getValue()).isEmpty()) {
            component.setOrigin(componentElement.getAttribute(DeviceEnum.ORIGIN.getValue()));
        } else {
            component.setOrigin("Unknown");
        }

        component.setPrice(Integer.parseInt(getElementTextContent(
                componentElement, DeviceEnum.PRICE.getValue())));

        component.setDeviceType(getElementTextContent(componentElement, DeviceEnum.DEVICE_TYPE.getValue()));

        component.setCritical(Boolean.parseBoolean(getElementTextContent(
                componentElement, DeviceEnum.CRITICAL.getValue())));

        Component.ComponentType type = component.getType();

        type.setCooler(Boolean.parseBoolean(getElementTextContent(
                componentElement, DeviceEnum.COOLER.getValue())));
        type.setPower(Float.parseFloat(getElementTextContent(
                componentElement, DeviceEnum.POWER.getValue())));
        return component;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
