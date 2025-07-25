package org.example.test_st10.Repository;

import org.example.test_st10.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // 1. Basic JPQL: Find employees by department
    @Query("SELECT e FROM Employee e WHERE e.department = :dept")
    List<Employee> findByDepartment(@Param("dept") String department);

    // 2. JPQL with LIKE: Find employees by partial first name
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE :namePattern")
    List<Employee> findByFirstNameLike(@Param("namePattern") String namePattern);

    // 3. JPQL with ORDER BY: Find all employees sorted by salary
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> findAllOrderBySalaryDesc();

    // 4. JPQL with JOIN: Find employees in a department with a specific name
//    @Query("SELECT e FROM Employee e JOIN Department d ON e.department = d.name WHERE d.name = :deptName")
//    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    // 5. JPQL with Aggregation: Count employees with salary above a threshold
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.salary > :minSalary")
    Long countEmployeesWithHighSalary(@Param("minSalary") Double minSalary);

    // 6. JPQL with Named Parameters: Find employees by first and last name
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName")
    Employee findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // 7. JPQL with Positional Parameters: Find employees by salary range
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> findBySalaryRange(Double minSalary, Double maxSalary);
}
