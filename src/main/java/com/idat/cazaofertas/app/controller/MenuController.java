package com.idat.cazaofertas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.cazaofertas.app.models.entity.Publicacion;
import com.idat.cazaofertas.app.models.entity.User;
import com.idat.cazaofertas.app.models.service.IProfile_UserService;
import com.idat.cazaofertas.app.models.service.IPublicacionService;

@Controller
public class MenuController {
	
	@Autowired
	private IPublicacionService iPublicacionService;
	
	@Autowired
	private IProfile_UserService iProfile_UserService;
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String listar(User user, Publicacion publicacion, Model m) {
		
		m.addAttribute("publicacion", new Publicacion());
		
		m.addAttribute("publicacion_th", iPublicacionService.listar());
		m.addAttribute("profile_th", iProfile_UserService.findByUser_UsernameProfile_User());
		
		return "menu";
	}
	
	@PostMapping("/publicar_profile")
	public String registrarPublicacion(Publicacion publicacion) {
		
		iPublicacionService.guardar(publicacion);
		
		return "redirect:/menu";
	}
	
}
