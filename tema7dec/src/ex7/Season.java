package ex7;

public enum Season {
    SPRING("Spring desc", 10.0),
    SUMMER("Summer desc", 21.0),
    AUTUMN("Autumn desc", 10.0),
    WINTER("Winter desc", 0.0);

    private final String desc;
    private final double avgTemp;

    Season(String desc, double avgTemp) {
        this.desc = desc;
        this.avgTemp = avgTemp;
    }

    public String getDesc() {
        return desc;
    }

    public double getAvgTemp() {
        return avgTemp;
    }
}
