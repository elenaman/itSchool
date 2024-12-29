package srp;

public class ReportGenerator {
    private final SalaryCalculator salaryCalculator;

    public ReportGenerator(SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }


    public void generateReport(Employee employee) {
        System.out.println("Employee Report:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Hours Worked: " + employee.getHoursWorked());
        System.out.println("Hourly Rate: $" + employee.getHourlyRate());
        System.out.println("Salary: $" + salaryCalculator.calculateSalary(employee));
    }
}
