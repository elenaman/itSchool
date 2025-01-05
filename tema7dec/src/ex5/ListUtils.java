package ex5;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> int countGreaterThan(List<T> list, T element) {
        int count = 0;
        for (T item : list) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

}
