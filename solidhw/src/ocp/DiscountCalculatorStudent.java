package ocp;

public class DiscountCalculatorStudent extends DiscountCalculator{
    @Override
    public double calculateDiscount(double price) {
        return price * 0.05;
    }
}
