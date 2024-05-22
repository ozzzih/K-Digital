package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.repository.BoardRepository;
import edu.pnu.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataInit implements ApplicationRunner {
	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		Member m1 = Member.builder()
					.id("member1").password("password1").name("홍길동")
					.role("USER").build();
		memberRepo.save(m1);
		Member m2 = Member.builder()
					.id("member2").password("password2").name("홍이동")
					.role("ADMIN").build();
		memberRepo.save(m2);
		Random rd = new Random();
		for(int i=1; i<5; i++) {
			boardRepo.save(Board.builder()
							.title("title1"+i)
							.writer("member1")
							.content("content1"+i)
							.createDate(new Date())
							.cnt(Math.abs(rd.nextLong()%100L))
							.member(m1)
							.build()
							);
		}
		for (int i=1; i<5; i++) {
			boardRepo.save(Board.builder()
					.title("title2"+i)
					.writer("member2")
					.content("content2"+i)
					.createDate(new Date())
					.cnt(Math.abs(rd.nextLong()%100L))
					.member(m2)
					.build());
		}
	}
}
