package github.com.celikyunusemre.employeemanagementsystem;

import github.com.celikyunusemre.employeemanagementsystem.model.Department;
import github.com.celikyunusemre.employeemanagementsystem.model.Employee;
import github.com.celikyunusemre.employeemanagementsystem.model.Position;
import github.com.celikyunusemre.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DummyData implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("John", "Doe", "555-1234", "1990-01-01", "123456789", "john.doe@example.com", "2020-01-01", Position.Manager, Department.IT, "10", "20", "5000", true));
        employeeRepository.save(new Employee("Jane", "Smith", "555-5678", "1995-02-15", "987654321", "jane.smith@example.com", "2020-02-15", Position.Engineer, Department.Engineering, "12", "18", "4000", true));
        employeeRepository.save(new Employee("Michael", "Johnson", "555-2468", "1988-07-10", "987123456", "michael.johnson@example.com", "2019-12-01", Position.Analyst, Department.Finance, "15", "15", "3500", true));
        employeeRepository.save(new Employee("Emily", "Brown", "555-1357", "1992-04-30", "654321987", "emily.brown@example.com", "2021-03-01", Position.Developer, Department.IT, "8", "22", "4500", true));
        employeeRepository.save(new Employee("David", "Miller", "555-9876", "1993-11-20", "789654123", "david.miller@example.com", "2021-06-01", Position.Manager, Department.HR, "12", "18", "5000", true));
        employeeRepository.save(new Employee("Sarah", "Anderson", "555-4321", "1991-06-05", "321987654", "sarah.anderson@example.com", "2022-01-01", Position.Engineer, Department.Engineering, "10", "20", "4000", true));
        employeeRepository.save(new Employee("Daniel", "Wilson", "555-7890", "1987-09-15", "456789123", "daniel.wilson@example.com", "2021-02-15", Position.Analyst, Department.Finance, "12", "18", "3500", true));
        employeeRepository.save(new Employee("Jennifer", "Taylor", "555-3698", "1989-03-12", "159357486", "jennifer.taylor@example.com", "2021-07-01", Position.Developer, Department.IT, "10", "20", "4500", true));
        employeeRepository.save(new Employee("Andrew", "Martinez", "555-8745", "1994-08-25", "852963741", "andrew.martinez@example.com", "2021-09-01", Position.Manager, Department.Marketing, "12", "18", "5000", true));
        employeeRepository.save(new Employee("Olivia", "Thomas", "555-6543", "1997-12-08", "741852963", "olivia.thomas@example.com", "2023-01-01", Position.Engineer, Department.Engineering, "8", "22", "4000", true));
        employeeRepository.save(new Employee("James", "Hernandez", "555-2580", "1996-10-18", "369852147", "james.hernandez@example.com", "2022-06-01", Position.Analyst, Department.Finance, "10", "20", "3500", true));
        employeeRepository.save(new Employee("Elizabeth", "Garcia", "555-7530", "1998-05-23", "258741369", "elizabeth.garcia@example.com", "2022-08-01", Position.Developer, Department.IT, "12", "18", "4500", true));
        employeeRepository.save(new Employee("Christopher", "Lee", "555-9512", "1990-09-02", "123987456", "christopher.lee@example.com", "2023-03-01", Position.Manager, Department.Operations, "10", "20", "5000", true));
        employeeRepository.save(new Employee("Megan", "Lopez", "555-3579", "1993-07-07", "987456123", "megan.lopez@example.com", "2022-10-01", Position.Engineer, Department.Engineering, "12", "18", "4000", true));
        employeeRepository.save(new Employee("Matthew", "Clark", "555-6842", "1992-11-12", "654789321", "matthew.clark@example.com", "2023-05-01", Position.Analyst, Department.Finance, "8", "22", "3500", true));
        employeeRepository.save(new Employee("Sophia", "Walker", "555-4127", "1995-01-29", "789123456", "sophia.walker@example.com", "2023-07-01", Position.Developer, Department.IT, "10", "20", "4500", true));
        employeeRepository.save(new Employee("William", "Hall", "555-2791", "1991-04-14", "321654987", "william.hall@example.com", "2022-04-01", Position.Manager, Department.Sales, "12", "18", "5000", true));
        employeeRepository.save(new Employee("Grace", "Young", "555-8164", "1988-08-21", "456123789", "grace.young@example.com", "2022-11-01", Position.Engineer, Department.Engineering, "10", "20", "4000", true));
        employeeRepository.save(new Employee("Daniel", "Gonzalez", "555-7581", "1987-03-05", "159486753", "daniel.gonzalez@example.com", "2023-01-01", Position.Analyst, Department.Finance, "12", "18", "3500", true));
        employeeRepository.save(new Employee("Ava", "Perez", "555-6248", "1996-06-16", "852369147", "ava.perez@example.com", "2023-03-01", Position.Developer, Department.IT, "8", "22", "4500", true));
    }
}
