package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.repository.BoardRepository;
@SpringBootTest
public class QueryMethodTest2 {
	@Autowired private BoardRepository boardRepo;
	Random rd = new Random();
	@BeforeEach //테스트 할때마다 쓰는거
	public void dataPrepare() {
		for(int i=1; i<=100; i++) {
			
			Board board = new Board();
			board.setTitle("테스트 제목 "+i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 "+i);
			board.setCreateDate(new Date());
			board.setCnt(Math.abs(rd.nextLong()%100L));
			boardRepo.save(board);
		}
	}
	
	
	@Test
	public void testByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("1");
		System.out.println("title에 '1'이 포함되는 데이터 검색 결과");
		for (Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
	}
	
	
	@Test
	public void testByTitleContainingAndCntGreaterThan() {
		List<Board> boardList = 
				boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
		
		System.out.println("title에 '1'에 포함되면서 cnt가 50보다 큰 데이터 검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
	}
	
	@Test
	public void testByCntBetweenOrderBySeq() {
		List<Board> boardList = 
				boardRepo.findByCntBetweenOrderBySeq(10, 50);
		
		System.out.println("cnt가 10보다 크고 50보다 작은 데이터 검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
	}
	
	@Test
	public void testByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = 
				boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		System.out.println("title에 '10'이 포함되거나 content에 '2'가 포함되는 데이터 검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
	}
	
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : "+pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : "+pageInfo.getTotalElements());
		System.out.println("NEXT : "+pageInfo.nextPageable());
		List<Board> boardList = pageInfo.getContent();
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->"+board.toString());
		}
	}
	
	
	
}
