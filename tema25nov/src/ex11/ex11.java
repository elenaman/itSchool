//Using the Student class, add students to a TreeSet<Student> based on their grade.
// Display the students in ascending order of grades.
package ex11;

import java.util.Set;
import java.util.TreeSet;

public class ex11 {
    public static void main(String[] args) {
        Student elena = new Student("Elena", 10.0);
        Student marcel = new Student("Marcel", 9.0);

        Set<Student> students = new TreeSet<>();
        students.add(marcel);
        students.add(elena);
        System.out.println(students);

    }
}
