package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//<Employee, Integer> --> entity type, primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it! we do not need to write any code!

}
