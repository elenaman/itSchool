//Create a TreeSet<Integer> and add random integers. Verify that the integers are stored in ascending order.
package noClass;

import java.util.Random;
import java.util.TreeSet;

public class ex8 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) { // Adding 10 random integers
            int randomNumber = random.nextInt(100); // Random number between 0 and 99
            treeSet.add(randomNumber);
        }

        boolean isAscending = isSortedInAscendingOrder(treeSet);
        System.out.println("Are the integers in ascending order? " + isAscending);

    }

    private static boolean isSortedInAscendingOrder(TreeSet<Integer> treeSet) {
        Integer prev = null;
        for (Integer current : treeSet) {
            if (prev != null && prev > current) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}
