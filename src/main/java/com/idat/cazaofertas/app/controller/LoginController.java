package com.idat.cazaofertas.app.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idat.cazaofertas.app.models.entity.Profile_User;
import com.idat.cazaofertas.app.models.entity.User;
import com.idat.cazaofertas.app.models.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService iUserService;

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, //captura por url (/login?error) de Spring Security
						@RequestParam(value="logout", required=false) String logout,//captura por url (/login?logout) de Spring Security
						@RequestParam(value="pro", required=false) String pro,
									Model model,
									Principal principal,
									RedirectAttributes flash) {
		
		model.addAttribute("user", new User());
		model.addAttribute("profile_user", new Profile_User());
		
		//manejar de error 
		if(error != null) { //ingresar usuario o contraseña incorrecto
			model.addAttribute("error", "Nombre de usuario o contraseña incorrecta"); //el mensaje aparece en login.html
		}
		if(principal != null) { //evitar hacer doble inicio de sesion
			flash.addFlashAttribute("info", "Ya ha iniciado sesion anteriormente"); //el mensaje aparecera en menu.html
			return "redirect:/menu"; //redirige al menu.html
		}
		
		//manejar exito
		if(logout != null) { //ingresar usuario o contraseña incorrecto
			model.addAttribute("success", "Haz cerrado sesion correctamente"); //el mensaje aparece en login.html
		}
		
		return "login";
	}
	
	@PostMapping("/registrologin")
	public String registrarPerfilUsuario(@Valid User user, BindingResult brUser, 
										@Valid Profile_User profile_User, BindingResult brProfile_User, 
										Model model) {
		
		if(brUser.hasErrors()||brProfile_User.hasErrors()) {
			return "redirect:/login";}
		
		iUserService.guardarProf_Usu(user, profile_User);
		
		return "redirect:/index";
	}
}




















