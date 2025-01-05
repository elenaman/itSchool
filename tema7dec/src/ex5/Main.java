package ex5;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ListUtils listUtils = new ListUtils();
        List<Integer> intList = List.of(1, 3, 5, 7, 9);
        System.out.println("Count greater than 4: " + listUtils.countGreaterThan(intList, 4));
    }
}
