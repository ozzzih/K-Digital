package edu.pnu.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor//final이 있는 애 자동으로 생성자만들어주는것
@RestController
public class MemberController {
	
	private final MemberService ms;
	
//	public MemberController() throws SQLException{
//		System.out.println("MemberController 생성");
////		ms=new MemberService();
////		ms.setMemberDao(new MemberDao());
//	}
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
