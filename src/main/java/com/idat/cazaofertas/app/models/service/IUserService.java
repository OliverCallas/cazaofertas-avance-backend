package com.idat.cazaofertas.app.models.service;

import com.idat.cazaofertas.app.models.entity.Employee;
import com.idat.cazaofertas.app.models.entity.User;

public interface IUserService {

	public User guardar(User usuario);
	
	public void guardarEmp_Usu(User user, Employee employee);
}
