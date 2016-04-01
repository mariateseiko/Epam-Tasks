package by.bsuir.task4.entity;

public class Component extends Device {
    private boolean critical;
    private ComponentType type = new ComponentType();

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean value) {
        this.critical = value;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType value) {
        this.type = value;
    }

    public static class ComponentType {
        private boolean cooler;
        private float power;

        public boolean getCooler() {
            return cooler;
        }

        public void setCooler(boolean value) {
            this.cooler = value;
        }

        public float getPower() {
            return power;
        }

        public void setPower(float value) {
            this.power = value;
        }
    }
}
