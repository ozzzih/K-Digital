package edu.pnu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public List<MemberVO> getAllMember(){
		return memberDao.getAllMember();
	}
	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}
	public MemberVO addMember(MemberVO membervo) {
		return memberDao.addMember(membervo);
	}
	public int updateMember(MemberVO membervo) {
		return memberDao.updateMembers(membervo);
	}
	public int deleteMember(Integer id) {
		return memberDao.removeMember(id);
	}
	
}
