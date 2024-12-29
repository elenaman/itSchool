package isp;
/**
 * Refactor the PaymentProcessor interface to adhere to ISP.
 */
public class Main {
    public static void main(String[] args) {
        PaymentProcessor creditCardPayment = new CreditCardProcessor();
        PaymentProcessor payPalPayment = new PayPalProcessor();

        creditCardPayment.processPayment();
        payPalPayment.processPayment();
    }
}
