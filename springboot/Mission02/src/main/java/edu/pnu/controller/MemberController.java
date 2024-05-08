package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
@RestController
public class MemberController {
	MemberService memberService;
	public MemberController() {
		memberService=new MemberService();		
	}
	
	// 검색(Read - select)
	@GetMapping("/members")
	public List<MemberVO> getAllMember() {
		return memberService.getAllMember();
	}
	// 검색(Read - select)
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {		
		return memberService.getMemberById(id);
	}
	// 입력(Create - insert)
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return memberService.addMember(memberVO);
	}
	// 수정(Update - update)
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		return memberService.updateMembers(memberVO);
	}
	// 삭제(Delete - delete)
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		return memberService.removeMember(id);
	}
	
	// 입력(Create - insert)
	@PostMapping("/memberJSON")
	public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
		return addMember(memberVO);
	}
	// 업데이트(Update)
	@PutMapping("/memberJSON")
	public int updateMemberJSON(@RequestBody MemberVO memberVO) {
		return updateMembers(memberVO);
	}
	
	// 삭제(delete)
	@DeleteMapping("/memberJSON")
	public int removeMemberJSON(@RequestBody Integer id) {
		return removeMember(id);
	}
	
	// id에 따른 member 출력
	@GetMapping("/memberJSON")
	public MemberVO getMemberByIdJSON(@RequestBody Integer id) {
		return getMemberById(id);
	}
}
