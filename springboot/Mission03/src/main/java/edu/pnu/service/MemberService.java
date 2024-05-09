package edu.pnu.service;


import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() {
		memberDao=new MemberDao();
	}
	public List<MemberVO> getAllMember(){
		return memberDao.getAllMember();
	}
	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}
	
}
