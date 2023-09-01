package github.com.celikyunusemre.employeemanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "identityNo", unique = true)
    private String identityNo;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "position")
    private Position position;
    @Column(name = "department")
    private Department department;
    @Column(name = "currentLeave")
    private String currentLeave;
    @Column(name = "leaveLeft")
    private String leaveLeft;
    @Column(name = "salary")
    private String salary;
    @Column(name = "isActive")
    private boolean isActive;

    public Employee(String firstName, String lastName, String phoneNumber, String dateOfBirth, String identityNo, String email, String startDate, Position position, Department department, String currentLeave, String leaveLeft, String salary, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.identityNo = identityNo;
        this.email = email;
        this.startDate = startDate;
        this.position = position;
        this.department = department;
        this.currentLeave = currentLeave;
        this.leaveLeft = leaveLeft;
        this.salary = salary;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", identityNo='" + identityNo + '\'' +
                ", email='" + email + '\'' +
                ", startDate='" + startDate + '\'' +
                ", position=" + position +
                ", department=" + department +
                ", currentLeave='" + currentLeave + '\'' +
                ", leaveLeft='" + leaveLeft + '\'' +
                ", salary='" + salary + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
