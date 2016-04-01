package by.bsuir.task4.parser;

import by.bsuir.task4.exception.XMLParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class DevicesSaxBuilder extends AbstractDevicesBuilder {
    private XMLReader reader;
    private DeviceHandler handler;

    public DevicesSaxBuilder() throws XMLParserException {
        handler = new DeviceHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            throw new XMLParserException("SAX parser configuration failed", e);
        }
    }

    public void buildSetDevices(String fileName) throws XMLParserException{
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            throw new XMLParserException("Sax parser failed", e);
        }
        peripherals = handler.getPeripherals();
        components = handler.getComponents();
    }
}
