package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOjpaImpl implements EmployeeDAO {
    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOjpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = query.getResultList();
        //return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee employee = entityManager.find(Employee.class, id);
        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee // if id == 0 then insert/save else update
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        //find employee by if
        Employee theEmployee = entityManager.find(Employee.class, id);
        //remove employee
        entityManager.remove(theEmployee);
    }
}
