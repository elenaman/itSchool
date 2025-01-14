package ex3;

import ex1.Student;

//Create an Employee class with:
//
//- int id
//- String name
//- String department
//- double salary
//
//- Implement Comparable<Employee> to sort by salary in descending order.
//- Override equals and hashCode to ensure employees are distinct based on id.
public class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    String department;
    Double salary;

    public Employee(Integer id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return -this.salary.compareTo(o.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee employee){
            return employee.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
