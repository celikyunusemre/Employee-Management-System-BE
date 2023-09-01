package github.com.celikyunusemre.employeemanagementsystem.controller;

import github.com.celikyunusemre.employeemanagementsystem.exception.BadRequestException;
import github.com.celikyunusemre.employeemanagementsystem.model.Department;
import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import github.com.celikyunusemre.employeemanagementsystem.model.Position;
import github.com.celikyunusemre.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(value = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private static final String EMPTY_ID_FIELD_MSG = "Id path can not be empty";
    private static final String POSITIVE_ID_FIELD_MSG = "Id path should be positive numeric";

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity
                .ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(EMPTY_ID_FIELD_MSG);
        } else if (id < 0) {
            throw new BadRequestException(POSITIVE_ID_FIELD_MSG);
        }
        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<List<Employee>> findPagination(
            @RequestParam("page") int page,
            @Nullable @RequestParam("size") int size,
            @Nullable @RequestParam("sortby") String sort
    ) {
        Pageable paging = PageRequest.of(
                page,
                size <= 0 ? 50 : size,
                Sort.by(sort == null ? "id" : sort).ascending()
        );
        Page<Employee> employees = employeeService.getEmployees(paging);

        return ResponseEntity.ok(employees.getContent());
    }

    @PostMapping
    public ResponseEntity<String> saveNewEmployee(
            @RequestBody Employee employee
    ) {
        employeeService.addEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Successfully added employee to system");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable Long id
    ) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(EMPTY_ID_FIELD_MSG);
        } else if (id < 0) {
            throw new BadRequestException(POSITIVE_ID_FIELD_MSG);
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().body("Employee deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployeeById(
            @PathVariable Long id,
            @RequestBody Employee employee
    ) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(EMPTY_ID_FIELD_MSG);
        } else if (id < 0) {
            throw new BadRequestException(POSITIVE_ID_FIELD_MSG);
        }
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok().body("Employee updated successfully");
    }

    @GetMapping("/departments")
    public ResponseEntity<List<String>> getDepartments() {
        List<String> enumNames = Stream.of(Department.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enumNames);
    }

    @GetMapping("/positions")
    public ResponseEntity<List<String>> getPositions() {
        List<String> enumNames = Stream.of(Position.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enumNames);
    }
}
