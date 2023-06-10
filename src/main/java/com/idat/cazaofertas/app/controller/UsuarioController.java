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

import com.idat.cazaofertas.app.models.entity.Usuario;
import com.idat.cazaofertas.app.models.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/registro")
	public String registroUsuario(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registrarUsuario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "registro";
		}

		iUsuarioService.guardar(usuario);
		status.setComplete();
		return "redirect:/index?exito";
	}
}
