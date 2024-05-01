package Testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import cse430.Employee;

public class EmployeeTesting {
    @Test
    public void testEmployeeConstructor() {
        Employee employee = new Employee(1, "Arnob Tanvir", "CSE", "Software Engineer", 50000.0);
        assertEquals(1, employee.getId());
        assertEquals("Arnob Tanvir", employee.getName());
        assertEquals("Software Engineer", employee.getJobTitle());
        assertEquals(50000.0, employee.getSalary(), 0.001);
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        Employee employee = new Employee(1, "Arnob Tanvir", "CSE", "Software Engineer", 50000.0);

        // test setid and getid
        employee.setId(2);
        assertEquals(2, employee.getId());
        // test setName and getName
        employee.setName("Abid Tahsin");
        assertEquals("Abid Tahsin", employee.getName());

        // test setDepartment and getDepartment
        employee.setDepartment("EEE");
        assertEquals("EEE", employee.getDepartment());

        // test setJobTitle and getJobTitle
        employee.setJobTitle("Electrical Engineer");
        assertEquals("Electrical Engineer", employee.getJobTitle());

        // test setSalary and getSalary
        employee.setSalary(60000.000);
        assertEquals(60000.0, employee.getSalary(), 0.001);

    }

}