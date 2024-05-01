package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        assertEquals(employee1, employeeManager.getEmployees().get(0));
        assertEquals(employee2, employeeManager.getEmployees().get(1));
        assertEquals(employee3, employeeManager.getEmployees().get(2));
        assertEquals(employee4, employeeManager.getEmployees().get(3));
        assertEquals(employee5, employeeManager.getEmployees().get(4));
    }

}
