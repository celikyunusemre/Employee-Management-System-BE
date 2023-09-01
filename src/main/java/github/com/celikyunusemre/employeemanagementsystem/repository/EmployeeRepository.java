package github.com.celikyunusemre.employeemanagementsystem.repository;

import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByFirstName(String firstName);
    Optional<Employee> findByLastName(String lastName);
    Optional<Employee> findByPhoneNumber(String phoneNumber);
    Optional<Employee> findByIdentityNo(String identityNo);
    boolean existsByIdentityNo(String identityNo);
}
