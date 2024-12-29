package ocp;
/**
 * Refactor the DiscountCalculator class to follow OCP using interfaces or abstract classes.
 * Add a new customer type (e.g., "Student") without modifying the existing logic.
 */
public class Main {
    public static void main(String[] args) {
        DiscountCalculator regularCalculator = new DiscountCalculatorRegular();
        DiscountCalculator vipCalculator = new DiscountCalculatorVIP();
        DiscountCalculator studentCalculator = new DiscountCalculatorStudent();

        System.out.println(regularCalculator.calculateDiscount(50));
        System.out.println(vipCalculator.calculateDiscount(50));
        System.out.println(studentCalculator.calculateDiscount(50));
    }
}
