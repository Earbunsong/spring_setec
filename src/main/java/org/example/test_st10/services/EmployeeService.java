package org.example.test_st10.services;

import org.example.test_st10.Repository.EmployeeRepository;
import org.example.test_st10.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesBySalaryRange(Double min, Double max) {
        return employeeRepository.findBySalaryRange(min, max);
    }
}
