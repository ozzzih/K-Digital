package edu.pnu.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;


@SessionAttributes("member")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		System.out.println("getboardlist");
		List<Board> boardList = boardService.getBoardList(board);
//		for(long i=1L; i<=10L; i++) {
//			boardList.add(Board.builder()
//								.seq(i)
//								.title("게시판 프로그램 테스트")
//								.writer("도우너")
//								.content("게시판 프로그램 테스트입니다.")
//								.createDate(new Date())
//								.cnt(0L)
//								.build());
//		}
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@GetMapping("/getBoard1")
	public ModelAndView getBoard(Model model, Long seq) {
		Board b = boardService.getBoard(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", b);
		mv.setViewName("getBoard");
		
		return mv;
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
