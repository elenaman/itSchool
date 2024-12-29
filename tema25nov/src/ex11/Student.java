package ex11;

public class Student implements Comparable<Student>{
    private final String name;
    private final Double grade;

    public Student(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }


    @Override
    public int compareTo(Student o) {
        return this.grade.compareTo(o.grade);
    }
}
