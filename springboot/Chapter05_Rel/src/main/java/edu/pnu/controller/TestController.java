package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.domain.Board;
import edu.pnu.repository.BoardRepository;

public class TestController {
	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("/boards")
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	
	@GetMapping("/board")
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}
	
	@PostMapping("/board")
	public Board insertBoard(Board board) {
		return boardRepo.save(board);
	}
	
	@PutMapping("/board")
	public Board putBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		b.update(board);
		return boardRepo.save(b);
	}
	
	@DeleteMapping("/board")
	public Board deleteBoard(@PathVariable Long seq) {
		Board b = boardRepo.findById(seq).get();
		boardRepo.deleteById(seq);
		return b;
	}
	
	
}
