package com.idat.cazaofertas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.cazaofertas.app.models.entity.Employee;


public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

}
