package com.idat.cazaofertas.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String registrarPublicacion(@RequestParam("file") MultipartFile imagen, Publicacion publicacion) {
		
		if(!imagen.isEmpty()) {
			
			String uniqueFilename = UUID.randomUUID().toString() + '_'+ imagen.getOriginalFilename();
			Path rootPath = Paths.get("uploads").resolve(uniqueFilename);
			
			Path rootAbsolutePath = rootPath.toAbsolutePath();
			
			try {
				Files.copy(imagen.getInputStream(), rootAbsolutePath);
				publicacion.setImagen(uniqueFilename);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		iPublicacionService.guardar(publicacion);
		
		return "redirect:/menu";
	}
	
}
