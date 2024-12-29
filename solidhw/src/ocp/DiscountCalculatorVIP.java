package ocp;

public class DiscountCalculatorVIP extends DiscountCalculator{

    @Override
    public double calculateDiscount(double price) {
        return price * 0.1;
    }
}
