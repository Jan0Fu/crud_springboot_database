package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int thId);

    public void save(Employee employee);

    public void deleteById(int theId);

    public List<Employee> searchBy(String theName);
}
