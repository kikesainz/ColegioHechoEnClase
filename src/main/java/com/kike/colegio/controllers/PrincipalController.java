package com.kike.colegio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}

}
