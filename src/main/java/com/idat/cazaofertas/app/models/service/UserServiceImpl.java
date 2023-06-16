package com.idat.cazaofertas.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.cazaofertas.app.models.entity.Employee;
import com.idat.cazaofertas.app.models.entity.User;
import com.idat.cazaofertas.app.models.repository.IEmployeeRepository;
import com.idat.cazaofertas.app.models.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public User guardar(User usu) {
		String encryptedPassword = passwordEncoder.encode(usu.getPassword());
		usu.setPassword(encryptedPassword);
        
		return iUserRepository.save(usu);
	}

	@Override
	public void guardarEmp_Usu(User user, Employee employee) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		User usuarioGuardado = iUserRepository.save(user);
		
        employee.setUser_id(usuarioGuardado.getId());
        employeeRepository.save(employee);
		
	}
}
