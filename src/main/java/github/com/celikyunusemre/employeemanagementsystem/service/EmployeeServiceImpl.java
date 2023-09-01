package github.com.celikyunusemre.employeemanagementsystem.service;

import github.com.celikyunusemre.employeemanagementsystem.exception.DuplicateDataException;
import github.com.celikyunusemre.employeemanagementsystem.exception.RecordNotFoundException;
import github.com.celikyunusemre.employeemanagementsystem.exception.UpdateException;
import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import github.com.celikyunusemre.employeemanagementsystem.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if (Objects.nonNull(id)) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            return optionalEmployee.orElse(null);
        }
        throw new RecordNotFoundException("Employee not found with id " + id);
    }

    @Override
    public void addEmployee(Employee employee) {
        if (Objects.nonNull(employee)) {
            if (employeeRepository.existsByIdentityNo(employee.getIdentityNo())) {
                throw new DuplicateDataException("Employee with same identity number ("+employee.getIdentityNo()+") is exist");
            }
            employeeRepository.save(employee);
        }
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee existingEmployee = employeeOptional.orElseThrow(
                () -> new RecordNotFoundException("Employee with id (" + id + ") does not exist")
        );

        if (StringUtils.isNotBlank(employee.getFirstName())) {
            existingEmployee.setFirstName(employee.getFirstName());
        }

        if (StringUtils.isNotBlank(employee.getLastName())) {
            existingEmployee.setLastName(employee.getLastName());
        }

        if (StringUtils.isNotBlank(employee.getPhoneNumber())) {
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        }

        if (StringUtils.isNotBlank(employee.getDateOfBirth())) {
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        }

        if (StringUtils.isNotBlank(employee.getIdentityNo())) {
            existingEmployee.setIdentityNo(employee.getIdentityNo());
        }

        try {
            employeeRepository.save(existingEmployee);
        } catch (Exception e) {
            throw new UpdateException("Failed to update employee with id (" + id +")");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        if (Objects.nonNull(id)) {
            if (!employeeRepository.existsById(id)) {
                throw new RecordNotFoundException("Employee with id (" + id + ") does not exist");
            }
            employeeRepository.deleteById(id);
        }
    }
}
