package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataInit implements ApplicationRunner {
	private final BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		for(int i=1; i<=5; i++) {
			boardRepo.save(Board.builder()
							.title("title1"+i)
							.writer("member1")
							.content("content1"+i)
							.createDate(new Date())
							.cnt(0L)
							.build()
							);
		}
		
	}
}