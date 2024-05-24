package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SecurityController {
	@GetMapping("/")
	public String index() {return "index";}
	
	@GetMapping("/member")
	public String memeber() {return "member";}
	
	@GetMapping("/manager")
	public String manager() {return "manager";}
	
	@GetMapping("/admin")
	public String admin() {return "admin";}
}
