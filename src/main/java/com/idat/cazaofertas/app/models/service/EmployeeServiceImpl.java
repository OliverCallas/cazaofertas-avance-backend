package com.idat.cazaofertas.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.cazaofertas.app.models.entity.Employee;
import com.idat.cazaofertas.app.models.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
    private IEmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public Employee guardar(Employee employee) {
		return employeeRepository.save(employee);
	}

}
