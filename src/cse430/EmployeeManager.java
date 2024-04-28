package cse430;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean removeEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findEmployeesByDepartment(String department) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                employeesInDepartment.add(employee);
            }
        }
        return employeesInDepartment;
    }

    public double calculateTotalSalary() {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

  
    public List<Employee> getEmployeesWithHighestSalary() {
        List<Employee> highestPaidEmployees = new ArrayList<>();
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                highestPaidEmployees.clear();
                highestPaidEmployees.add(employee);
            } else if (employee.getSalary() == maxSalary) {
                highestPaidEmployees.add(employee);
            }
        }
        return highestPaidEmployees;
    }

    
    public List<Employee> findEmployeesByJobTitle(String jobTitle) {
        List<Employee> employeesWithJobTitle = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getJobTitle().equalsIgnoreCase(jobTitle)) {
                employeesWithJobTitle.add(employee);
            }
        }
        return employeesWithJobTitle;
    }
}
