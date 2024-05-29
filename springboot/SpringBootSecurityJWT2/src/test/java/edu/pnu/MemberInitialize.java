package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;
@SpringBootTest
public class MemberInitialize {
	@Autowired
	MemberRepository memRepo; //Table Member CRUD 인터페이스
	
	PasswordEncoder encoder = new BCryptPasswordEncoder(); //비밀번호 암호화 인터페이스/구현체
	
	@Test
	public void doWork() {
		memRepo.save(Member.builder()
					.username("marketing")
					.password(encoder.encode("abcd"))
					.role(Role.ROLE_MARKETING)
					.enabled(true).build());
		memRepo.save(Member.builder()
					.username("finance")
					.password(encoder.encode("abcd"))
					.role(Role.ROLE_FINANCE)
					.enabled(true).build());
		memRepo.save(Member.builder()
				.username("develop")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_DEVELOP)
				.enabled(true).build());
		memRepo.save(Member.builder()
					.username("admin")
					.password(encoder.encode("abcd"))
					.role(Role.ROLE_ADMIN)
					.enabled(true).build());
	}
}
