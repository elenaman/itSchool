package noClass;

import java.util.ArrayList;
import java.util.List;

//Create a List<Double> with positive and negative numbers.
// Write a method to remove all negative numbers from the list.
public class ex3 {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(3.14);
        numbers.add(-2.71);
        numbers.add(1.62);
        numbers.add(-4.0);
        numbers.add(7.89);
        numbers.add(-1.23);
        List<Double> positiveNumbers = getPositiveNumbers(numbers);

        System.out.println(positiveNumbers);

    }

    private static List<Double> getPositiveNumbers(List<Double> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 0){
                numbers.remove(i);
            }
        }

        return numbers;
    }
}
