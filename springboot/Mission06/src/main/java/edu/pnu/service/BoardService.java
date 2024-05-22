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
public class BoardService {
	private final BoardRepository boardRepo;
	public List<Board> getboard(){
		return boardRepo.findAll();
	}
	public List<Board> updateboard(Long id){
		boardRepo.findById(id);                                           
		return boardRepo.findAll();
	}
}
