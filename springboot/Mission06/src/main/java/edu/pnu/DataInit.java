package edu.pnu;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@Component
public class DataInit implements ApplicationRunner{
	
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		Member m1=	Member.builder()
							.username("member"+1)
							.password("pass"+1)
							.role("USER")
							.build();
		memberRepo.save(m1);
		Member m2=	Member.builder()
				.username("member"+2)
				.password("pass"+2)
				.role("USER")
				.build();
		memberRepo.save(m2);
		
		for(int i=1; i<5; i++) {
			
			boardRepo.save(Board.builder()
					.title("title1"+i)
					.content("content1"+i)
					.member(m1)
					.build()
					);
		}
		for(int i=1; i<5; i++) {
			
			boardRepo.save(Board.builder()
					.title("title2"+i)
					.content("content2"+i)
					.member(m2)
					.build()
					);
		}
	}
}
