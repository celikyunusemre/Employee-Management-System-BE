package github.com.celikyunusemre.employeemanagementsystem.service;

import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Page<Employee> getEmployees(Pageable pageable);
    Employee getEmployeeById(Long id);
    void addEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
