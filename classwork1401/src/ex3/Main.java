package ex3;

import ex1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//- Create a list of employees in multiple departments.
//
//- Use streams to:
//-- Calculate the average salary of employees per department.
//-- Find the top 3 highest-paid employees across all departments.
//-- Partition employees into two groups: those earning more than a given amount and those earning less.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000.0));
        employees.add(new Employee(2, "Bob", "IT", 70000.0));
        employees.add(new Employee(3, "Charlie", "Finance", 60000.0));
        employees.add(new Employee(4, "David", "IT", 90000.0));
        employees.add(new Employee(5, "Eve", "HR", 45000.0));
        employees.add(new Employee(6, "Frank", "Finance", 80000.0));
        System.out.println("Avg per department");
        Map<String, Double> avgSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        avgSalaryPerDept.forEach((s, aDouble) -> System.out.println(s + " " + aDouble));

        System.out.println("Top 3 salaries");
        List<Employee> top3 = employees.stream()
                .sorted()
                .limit(3)
                .toList();

        top3.forEach(s -> System.out.println(s.name + " " + s.salary));

        System.out.println("Grouped by salary");
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 61000));

        System.out.println("Employees earning more than " + 61000 + ":");
        partitionedBySalary.get(true).forEach(s -> System.out.println(s.name + " " + s.salary));

        System.out.println("Employees earning less than or equal to " + 61000 + ":");
        partitionedBySalary.get(false).forEach(s -> System.out.println(s.name + " " + s.salary));

    }
}
