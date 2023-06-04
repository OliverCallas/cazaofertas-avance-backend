package com.idat.cazaofertas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping(value={"/index","","/","home"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
}
