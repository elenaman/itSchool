package noClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

//Create a List<Integer> and populate it with random integers. Sort the list in ascending and descending order.
public class ex1 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();

        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            intList.add(random.nextInt(100));
        }


        List<Integer> ascendingList = new ArrayList<Integer>(intList);
        Collections.sort(ascendingList);
        System.out.println("Sorted List in Ascending Order: " + ascendingList);


        List<Integer> descendingList = new ArrayList<Integer>(intList);
        Collections.sort(descendingList, Collections.reverseOrder());
        System.out.println("Sorted List in Ascending Order: " + descendingList);







    }
}
