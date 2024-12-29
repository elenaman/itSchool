package ex7;

import java.util.ArrayList;
import java.util.List;

//Using the Student class, create a list of students with different grades.
// Find and display the top 3 students based on their grades.
public class ex7 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 18, 10));
        students.add(new Student("Bob", 19,9));
        students.add(new Student("Charlie",20, 7));
        students.add(new Student("Diana", 18, 9));
        students.add(new Student("Eve", 18, 10));

        List<Student> topStudents = getTopStudents(students, 3);
        System.out.println("Top 3 Students:");
        for (Student student : topStudents) {
            System.out.println(student.getName());
        }
    }

    private static List<Student> getTopStudents(List<Student> students,int topNo) {
        List<Student> topStudents = new ArrayList<>();
        for (int i = 0; i < topNo; i++) {
            Student maxStudent = null;
            for (Student student : students) {
                if ((maxStudent == null || student.getGrade() > maxStudent.getGrade()) && !topStudents.contains(student)) {
                    maxStudent = student;
                }
            }
            if (maxStudent != null) {
                topStudents.add(maxStudent);
            }
        }
        return topStudents;
    }
}
