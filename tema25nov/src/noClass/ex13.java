//Create two Set<Integer> objects with some common elements.
// Write methods to find the union, intersection, and difference of these sets.
package noClass;

import java.util.HashSet;
import java.util.Set;

public class ex13 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        System.out.println("Union: " + getUnion(set1,set2));
        System.out.println("Intersection: " + getIntersection(set1,set2));
        System.out.println("Difference: " + getDifference(set1,set2));
    }

    private static Set<Integer> getDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> difference = new HashSet<>();
        for(Integer num: set1){
            if(!set2.contains(num)){
                difference.add(num);
            }
        }
        return difference;
    }

    private static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();
        for(Integer num: set2){
            if(set1.contains(num)){
                intersection.add(num);
            }
        }
        return intersection;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        for(Integer num: set2){
            union.add(num);
        }
        return union;
    }



}
