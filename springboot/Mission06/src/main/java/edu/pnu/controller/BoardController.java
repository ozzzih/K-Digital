package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;
import edu.pnu.service.MemberService;

@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	@GetMapping("/board")
	public List<Board> getBoard(){
		return boardService.getboard();
	}
}
