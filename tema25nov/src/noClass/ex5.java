package noClass;

import java.util.ArrayList;
import java.util.List;

//Populate a List<Integer>, then convert each integer to its string representation and store it in a new List<String>.
public class ex5 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        integers.add(50);

        List<String> stringList = convertToString(integers);
        System.out.println(stringList);
    }

    private static List<String> convertToString(List<Integer> integers) {
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < integers.size(); i++){
            stringList.add(integers.get(i).toString());
        }
        return stringList;
    }
}
