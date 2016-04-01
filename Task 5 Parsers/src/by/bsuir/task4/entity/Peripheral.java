
package by.bsuir.task4.entity;

public class Peripheral extends Device
{
    private boolean plugAndPlay;
    private PeripheralType type = new PeripheralType();

    public boolean isPlugAndPlay() {
        return plugAndPlay;
    }

    public void setPlugAndPlay(boolean value) {
        this.plugAndPlay = value;
    }

    public PeripheralType getType() {
        return type;
    }

    public void setType(PeripheralType value) {
        this.type = value;
    }

    public static class PeripheralType {
        private String group;
        private String port;

        public String getGroup() {
            return group;
        }
        public void setGroup(String value) {
            this.group = value;
        }
        public String getPort() {
            return port;
        }
        public void setPort(String value) {
            this.port = value;
        }
    }

}
