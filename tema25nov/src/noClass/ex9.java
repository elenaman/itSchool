//Create a TreeSet<String> and add various city names.
// Display the cities in alphabetical order.
// Then try to display them in reverse alphabetical order.
package noClass;

import java.util.TreeSet;

public class ex9 {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();

        // Add city names to the TreeSet
        cities.add("New York");
        cities.add("London");
        cities.add("Paris");
        cities.add("Tokyo");
        cities.add("Sydney");
        cities.add("Mumbai");
        cities.add("Beijing");

        System.out.println("Cities in alphabetical order: " + cities);

        System.out.println("Cities in reverse order:" + cities.descendingSet());

    }

}
