package ex1;

public class Student implements Comparable<Student>{
    Integer id;
    String name;
    Double grade;

    public Student(Integer id, String name, Double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return this.grade.compareTo(o.grade);
    }

    //Override equals and hashCode
    // to ensure two students are distinct if their id is different.

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student student){
            return student.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
