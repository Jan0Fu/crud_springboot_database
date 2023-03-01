package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        Employee empl1 = new Employee(1, "Leslie", "Andrews", "leslie@and.com");
        Employee empl2 = new Employee(2, "Jane", "Doe", "jane@doe.com");
        Employee empl3 = new Employee(3, "John", "Smith", "john@smt.com");
        theEmployees = new ArrayList<>();
        theEmployees.add(empl1);
        theEmployees.add(empl2);
        theEmployees.add(empl3);
    }

    @GetMapping("/list")
    public String ss(Model theModel) {
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
