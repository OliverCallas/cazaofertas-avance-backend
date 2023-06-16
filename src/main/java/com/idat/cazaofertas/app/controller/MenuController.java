package com.idat.cazaofertas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.cazaofertas.app.models.service.IPublicacionService;

@Controller
public class MenuController {
	
	@Autowired
	//@Qualifier("clienteDaoJPA")
	private IPublicacionService iPublicacionService;
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String listar(Model m) {
		
		m.addAttribute("publicacion_th", iPublicacionService.listar());
		
		return "menu";
	}
}
