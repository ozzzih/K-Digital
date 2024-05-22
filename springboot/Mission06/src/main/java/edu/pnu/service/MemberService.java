package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepo;
	public List<Member> getmember(){
		return memberRepo.findAll();
	}
	public List<Member> deletemember(Integer id){
		memberRepo.deleteById("username"+id);
		return memberRepo.findAll();
	}

}

