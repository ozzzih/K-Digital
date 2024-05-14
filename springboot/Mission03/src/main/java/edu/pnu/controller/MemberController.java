package edu.pnu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
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
	@PostMapping("/member")
	public ResponseEntity<?> addMember( String pass,  String name ){ 
	//public ResponseEntity<?> addMember( MemberVO membervo ){
		return ResponseEntity.ok(ms.addMember(MemberVO.builder().pass(pass).name(name).build()));
		//return ResponseEntity.ok(ms.addMember(membervo));
	}
	@PutMapping("/member")
	public ResponseEntity<?> updateMember(Integer id, String pass, String name){
		return ResponseEntity.ok(ms.updateMember(MemberVO.builder().pass(pass).name(name).id(id).build()));
	}
	@DeleteMapping("/member")
	public ResponseEntity<?> deleteMember(Integer id){
		return ResponseEntity.ok(ms.deleteMember(id));
	}
	
	
}
