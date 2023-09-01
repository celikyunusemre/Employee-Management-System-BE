package github.com.celikyunusemre.employeemanagementsystem.repository;

import github.com.celikyunusemre.employeemanagementsystem.model.Department;
import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import github.com.celikyunusemre.employeemanagementsystem.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository underTest;

    @Test
    void itShouldFindByFirstName() {
        final String firstName = "Noah";
        Employee employee = new Employee(
                firstName,
                "Anderson",
                "555-1357",
                "1992-04-30",
                "6543219857",
                "noah.anderson@example.com",
                "2021-03-01",
                Position.Developer,
                Department.IT,
                "8",
                "22",
                "4500",
                true
        );
        underTest.save(employee);

        Optional<Employee> savedEmployee = underTest.findByFirstName(firstName);
        assertTrue(savedEmployee.isPresent());
        underTest.delete(employee);
    }

    @Test
    void itShouldFindByLastName() {
        final String lastName = "Davis";
        Employee employee = new Employee(
                "Ava",
                lastName,
                "555-9876",
                "1993-11-20",
                "7896541253",
                "ava.davis@example.com",
                "2021-06-01",
                Position.Manager,
                Department.HR,
                "12",
                "18",
                "5000",
                true
        );

        underTest.save(employee);

        Optional<Employee> savedEmployee = underTest.findByLastName(lastName);
        assertTrue(savedEmployee.isPresent());
        underTest.delete(employee);
    }

    @Test
    void itShouldFindByPhoneNumber() {
        final String phoneNumber = "555-43251";
        Employee employee = new Employee(
                "Oliver",
                "Wilson",
                phoneNumber,
                "1991-06-05",
                "3219876524",
                "oliver.wilson@example.com",
                "2022-01-01",
                Position.Engineer,
                Department.Engineering,
                "10",
                "20",
                "4000",
                true
        );

        underTest.save(employee);

        Optional<Employee> savedEmployee = underTest.findByPhoneNumber(phoneNumber);
        assertTrue(savedEmployee.isPresent());
        underTest.delete(employee);
    }

    @Test
    void itShouldFindByIdentityNo() {
        final String identityNumber = "4567891253";
        Employee employee = new Employee(
                "Emma",
                "Garcia",
                "555-7890",
                "1987-09-15",
                identityNumber,
                "emma.garcia@example.com",
                "2021-02-15",
                Position.Analyst,
                Department.Finance,
                "12",
                "18",
                "3500",
                true
        );
        underTest.save(employee);

        Optional<Employee> savedEmployee = underTest.findByIdentityNo(identityNumber);
        assertTrue(savedEmployee.isPresent());
        underTest.delete(employee);
    }
}