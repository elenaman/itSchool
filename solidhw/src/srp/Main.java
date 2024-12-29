package srp;
/**
 * Refactor the Employee class to adhere to SRP.
 * Split responsibilities into separate classes.
 */
public class Main {
    public static void main(String[] args) {
        Employee elena = new Employee("elena", 40, 50.5);

        SalaryCalculator salaryCalculator = new SalaryCalculator();

        ReportGenerator reportGenerator = new ReportGenerator(salaryCalculator);
        reportGenerator.generateReport(elena);
    }
}
