//Create a Set<String> to store student names.
// Add several names, some of them duplicates, and verify that the set only keeps unique names.
package noClass;

import java.util.HashSet;
import java.util.Set;

public class ex10 {
    public static void main(String[] args) {
        Set<String> studentNames = new HashSet<>();

        // Add student names to the set
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("Diana");
        studentNames.add("Eve");
        studentNames.add("Frank");
        studentNames.add("Alice");

        System.out.println(studentNames);

        Set <String> helperSet = new HashSet<>();
        for(String student: studentNames){
            if (!helperSet.contains(student)) {
                helperSet.add(student);
            }
        }
        if(studentNames.size() == helperSet.size()){
            System.out.println("No duplicates found");
        }
    }
}
