package ex9;

public class Main {
    public static void main(String[] args) {
        CoffeeSize size = CoffeeSize.LARGE;
        int quantify = 4;

        double totalCost = size.calculateCose(quantify);
        System.out.println("Cost for 4 large coffees: " + totalCost);
    }
}
