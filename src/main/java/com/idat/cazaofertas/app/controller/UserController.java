package com.idat.cazaofertas.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.idat.cazaofertas.app.models.entity.Employee;
import com.idat.cazaofertas.app.models.entity.User;
import com.idat.cazaofertas.app.models.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/registro")
	public String registroUsuario(Map<String, Object> model) {
		
		model.put("user", new User());
		model.put("employee", new Employee());
		
		return "registro";
	}
	
	@PostMapping("/registrosys")
	public String registrarUsuarioSistema(@Valid User user, BindingResult brUser, @Valid Employee employee, BindingResult brEmployee, Model model, SessionStatus status) {
		
		if(brUser.hasErrors()||brEmployee.hasErrors()) {
			return "registro";}
		
		iUserService.guardarEmp_Usu(user, employee);
		
		status.setComplete();
		
		return "redirect:/index?exito";
	}
}
