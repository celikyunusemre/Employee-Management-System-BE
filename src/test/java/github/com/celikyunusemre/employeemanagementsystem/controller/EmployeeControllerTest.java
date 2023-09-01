package github.com.celikyunusemre.employeemanagementsystem.controller;

import github.com.celikyunusemre.employeemanagementsystem.model.Department;
import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import github.com.celikyunusemre.employeemanagementsystem.model.Position;
import github.com.celikyunusemre.employeemanagementsystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void itShouldGetAllEmployees() {
        ResponseEntity<List<Employee>> employees = employeeController.getAllEmployees();
        // Verify the response
        assertEquals(HttpStatus.OK, employees.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(employees.getBody());
    }

    @Test
    void itShouldGetEmployeeById() {
        Employee employee = saveEmployee(new Employee(
            "Eleanor",
            "Williams",
            "555-1234",
            "1990-01-01",
            "123456789",
            "eleanor.williams@example.com",
            "2020-01-01",
            Position.Manager,
            Department.IT,
            "10",
            "20",
            "5000",
            true
        ));
        ResponseEntity<Employee> result = employeeController.getEmployeeById(employee.getId());
        // Verify the response
        assertEquals(HttpStatus.OK, result.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(result.getBody());
    }

    @Test
    void itShouldFindByPagination() {
        ResponseEntity<List<Employee>> employees = employeeController.findPagination(0, 10, "id");
        // Verify the response
        assertEquals(HttpStatus.OK, employees.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(employees.getBody());
    }

    @Test
    void itShouldSaveNewEmployee() {
        Employee employee = new Employee(
            "Liam",
            "Brown",
            "555-5678",
            "1995-02-15",
            "9876543251",
            "liam.brown@example.com",
            "2020-02-15",
            Position.Engineer,
            Department.Engineering,
            "12",
            "18",
            "4000",
            true
        );
        ResponseEntity<String> employeeResponse = employeeController.saveNewEmployee(employee);
        // Verify the response
        assertEquals(HttpStatus.CREATED, employeeResponse.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(employeeResponse.getBody());
    }

    @Test
    void itShouldDeleteEmployeeById() {
        ResponseEntity<String> employeeResponse = employeeController.deleteEmployeeById(1L);
        // Verify the response
        assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(employeeResponse.getBody());
    }

    @Test
    void itShouldUpdateEmployeeById() {
        Employee employee = saveEmployee(new Employee(
            "Sophia",
            "Martin",
            "555-2468",
            "1988-07-10",
            "9871234556",
            "sophia.martin@example.com",
            "2019-12-01",
            Position.Analyst,
            Department.Finance,
            "15",
            "15",
            "3500",
            true
        ));
        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName("Emre Yunus");
        ResponseEntity<String> employeeResponse = employeeController.updateEmployeeById(employee.getId(), updatedEmployee);
        // Verify the response
        assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
        // Assert that the response body is not null
        assertNotNull(employeeResponse.getBody());
    }

    private Employee saveEmployee(Employee employee) {
        employeeController.saveNewEmployee(employee);
        return employeeRepository.findByIdentityNo(employee.getIdentityNo()).get();
    }
}