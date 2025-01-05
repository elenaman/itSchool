package ex9;

public enum CoffeeSize {
    SMALL(200, 10.5),
    MEDIUM(300, 13.0),
    LARGE(400, 15.0);

    private final int volume;
    private final double price;

    CoffeeSize(int volume, double price) {
        this.volume = volume;
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public double calculateCose(int quantity){
        return price * quantity;
    }


}
