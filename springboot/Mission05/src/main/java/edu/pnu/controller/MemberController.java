package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.MemberService;
@RestController
public class MemberController {
	MemberService ms;
	public MemberController(){
		ms=new MemberService();
	}
	@GetMapping("/member")
	public ResponseEntity<?> getAllMember(){
		return ResponseEntity.ok(ms.getAllMember());
	}
	@GetMapping("/member/{id}")
	public ResponseEntity<?> getMember(@PathVariable Integer id){
		if(id==null)
			ResponseEntity.ok(ms.getAllMember());
		return ResponseEntity.ok(ms.getMember(id));
	}
	
}