package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Create a List<Student> with at least 10 students (some with the same grade or name).
//Use a stream to:
//-- Filter students with a grade higher than a given threshold.
//-- Sort the students by grade using the natural order (Comparable).
//-- Collect the sorted students into a new list.
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding students to the list
        students.add(new Student(1,"Alice", 9.0));
        students.add(new Student(2, "Bob", 8.5));
        students.add(new Student(3, "Charlie", 9.0));
        students.add(new Student(4,"Diana", 8.0));
        students.add(new Student(5,"Eve", 8.5));
        students.add(new Student(6,"Frank", 7.0));
        students.add(new Student(7,"Grace", 9.5));
        students.add(new Student(8,"Hank", 7.0));
        students.add(new Student(9,"Alice", 8.8));
        students.add(new Student(10,"Ivy", 9.2));

        List<Student> sortedStudents = students.stream().filter(s -> s.grade > 7)
                .sorted()
                .toList();

        for (Student student : sortedStudents) {
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.grade);
        }
    }
}
