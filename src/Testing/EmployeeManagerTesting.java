package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cse430.Employee;
import cse430.EmployeeManager;

public class EmployeeManagerTesting {

    EmployeeManager employeeManager = new EmployeeManager();

    Employee employee1 = new Employee(1, "Arnob Tanvir", "CSE", "Web Developer", 50000.0);
    Employee employee2 = new Employee(2, "Arifin Zaman", "EEE", "Electric Engineer", 60000.0);
    Employee employee3 = new Employee(3, "Sumaiya Tabassum", "CSE", "Quality Assurance Engineer", 55000.0);
    Employee employee4 = new Employee(4, "Farhan Sharier", "CSE", "Android Developer", 70000.0);
    Employee employee5 = new Employee(5, "Abid Tahsin", "CSE", "Android Developer", 70000.0);

    @Test
    public void addEmployeeTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        assertEquals(5, employeeManager.getEmployees().size());
        assertEquals(employee1, employeeManager.getEmployees().get(0));
        assertEquals(employee2, employeeManager.getEmployees().get(1));
        assertEquals(employee3, employeeManager.getEmployees().get(2));
        assertEquals(employee4, employeeManager.getEmployees().get(3));
        assertEquals(employee5, employeeManager.getEmployees().get(4));
    }

    @Test
    public void removeEmployeeTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        assertTrue(employeeManager.removeEmployee(1));
        assertTrue(employeeManager.removeEmployee(2));
        assertTrue(employeeManager.removeEmployee(3));
        assertTrue(employeeManager.removeEmployee(4));
        assertTrue(employeeManager.removeEmployee(5));

        assertEquals(0, employeeManager.getEmployees().size());
    }

    @Test
    public void findEmployeeByIdTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        assertEquals(employee1, employeeManager.findEmployeeById(1));
        assertEquals(employee2, employeeManager.findEmployeeById(2));
        assertEquals(employee3, employeeManager.findEmployeeById(3));
        assertEquals(employee4, employeeManager.findEmployeeById(4));
        assertEquals(employee5, employeeManager.findEmployeeById(5));
    }

    @Test
    public void findEmployeesByDepartmentTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        List<Employee> cseDepartment = new ArrayList<>();
        cseDepartment = employeeManager.findEmployeesByDepartment("CSE");

        List<Employee> eeeDepartment = new ArrayList<>();
        eeeDepartment = employeeManager.findEmployeesByDepartment("EEE");

        assertEquals(4, employeeManager.findEmployeesByDepartment("CSE").size());
        assertEquals(1, employeeManager.findEmployeesByDepartment("EEE").size());

        assertEquals(employee1, cseDepartment.get(0));
        assertEquals(employee3, cseDepartment.get(1));
        assertEquals(employee4, cseDepartment.get(2));
        assertEquals(employee5, cseDepartment.get(3));

        assertEquals(employee2, eeeDepartment.get(0));

    }

    @Test
    public void calculateTotalSalaryTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        assertEquals(305000.0, employeeManager.calculateTotalSalary(), 0.001);

    }

    @Test
    public void getEmployeesWithHighestSalaryTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        List<Employee> highestPaidEmployees = new ArrayList<>();

        highestPaidEmployees = employeeManager.getEmployeesWithHighestSalary();

        assertEquals(2, highestPaidEmployees.size());

        assertEquals(employee4, highestPaidEmployees.get(0));
        assertEquals(employee5, highestPaidEmployees.get(1));
    }

    @Test
    public void findEmployeesByJobTitleTesting() {
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        employeeManager.addEmployee(employee4);
        employeeManager.addEmployee(employee5);

        List<Employee> webDeveloper = new ArrayList<>();
        webDeveloper = employeeManager.findEmployeesByJobTitle("Web Developer");

        List<Employee> electricEngineer = new ArrayList<>();
        electricEngineer = employeeManager.findEmployeesByJobTitle("Electric Engineer");

        List<Employee> qualityAssuranceEngineer = new ArrayList<>();
        qualityAssuranceEngineer = employeeManager.findEmployeesByJobTitle("Quality Assurance Engineer");

        List<Employee> androidDeveloper = new ArrayList<>();
        androidDeveloper = employeeManager.findEmployeesByJobTitle("Android Developer");

        assertEquals(1, webDeveloper.size());
        assertEquals(1, electricEngineer.size());
        assertEquals(1, qualityAssuranceEngineer.size());
        assertEquals(2, androidDeveloper.size());

        assertEquals(employee1, webDeveloper.get(0));
        assertEquals(employee2, electricEngineer.get(0));
        assertEquals(employee3, qualityAssuranceEngineer.get(0));
        assertEquals(employee4, androidDeveloper.get(0));
        assertEquals(employee5, androidDeveloper.get(1));

    }

}
