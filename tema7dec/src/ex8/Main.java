package ex8;

public class Main {
    public static void main(String[] args) {
        TrafficLight light = TrafficLight.RED;

        // Simulate traffic light transitions
        for (int i = 0; i < 6; i++) {
            System.out.println("Current light: " + light);
            light = light.next();
        }
    }
}
