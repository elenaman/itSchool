package ex8;

public enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight next() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
