package edu.pnu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class MemberService {
	
	
	private final MemberDao memberDao;
	
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//	public MemberService() {
//		System.out.println("Service실행");
//	}
	public List<MemberVO> getAllMember(){
		return memberDao.getAllMember();
	}
	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}
	
}
