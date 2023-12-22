package com.nrift.springSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity
public class HomeController {

	@GetMapping("/welcome")
	public String home() {
		System.out.println("hi");
		return "welcome home";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String admin() {
		return "welcome admin";
	}

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/usr")
	public String usr() {
		return "welcome usr";
	}
}
