package by.bsuir.task4.parser;

public enum DeviceEnum {
    DEVICES("devices"),
    PERIPHERAL("peripheral"),
    COMPONENT("component"),
    NAME("name"),
    ORIGIN("origin"),
    PERIPHERAL_TYPE("peripheral-type"),
    COMPONENT_TYPE("component-type"),
    PRICE("price"),
    PLUG_AND_PLAY("plug-and-play"),
    DEVICE_TYPE("device-type"),
    CRITICAL("critical"),
    GROUP("group"),
    PORT("port"),
    COOLER("cooler"),
    POWER("power");

    private String value;
    DeviceEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static DeviceEnum getEnum(String value) {
        for(DeviceEnum v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException(value + " is not present");
    }
}
