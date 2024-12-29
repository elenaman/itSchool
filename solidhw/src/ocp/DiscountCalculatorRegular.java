package ocp;

public class DiscountCalculatorRegular extends DiscountCalculator{

    @Override
    public double calculateDiscount(double price) {
        return price * 0.5;
    }
}
