package srp;

public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return employee.getHoursWorked() * employee.getHourlyRate();
    }
}
