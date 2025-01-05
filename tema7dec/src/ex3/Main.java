package ex3;

public class Main {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.addElement(11);
        intContainer.addElement(22);
        intContainer.addElement(33);
        System.out.println("Sum of integers: " + intContainer.sum());

        Container<Double> doubleContainer = new Container<>();
        doubleContainer.addElement(1.1);
        doubleContainer.addElement(2.2);
        doubleContainer.addElement(3.3);
        System.out.println("Sum of doubles: " + doubleContainer.sum());
    }
}
