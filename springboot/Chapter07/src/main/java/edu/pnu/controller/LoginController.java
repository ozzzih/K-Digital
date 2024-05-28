package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@Controller
@SessionAttributes("member")
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	
	
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
	
	@GetMapping("/login")
	public void login() {
		System.out.println("login 요청");
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		System.out.println(
				"loginSuccess 요청");
		}
	@GetMapping("/accessDenied")
	public void accessDenied() {
	System.out.println("accessDenied");
	}
}

