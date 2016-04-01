package by.bsuir.task4.factory;

import by.bsuir.task4.exception.XMLParserException;
import by.bsuir.task4.parser.AbstractDevicesBuilder;
import by.bsuir.task4.parser.DevicesDomBuilder;
import by.bsuir.task4.parser.DevicesSaxBuilder;
import by.bsuir.task4.parser.DevicesStaxBuilder;


public class DeviceBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractDevicesBuilder createDevicesBuilder(String typeParser) throws XMLParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DevicesDomBuilder();
            case STAX:
                return new DevicesStaxBuilder();
            case SAX:
                return new DevicesSaxBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
