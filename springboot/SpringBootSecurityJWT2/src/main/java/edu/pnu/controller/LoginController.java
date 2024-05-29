package edu.pnu.controller;


import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Member;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController

public class LoginController {
	//인증 객체
	
	private final AuthenticationConfiguration authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member){
		try {
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());
			
			//인증 진행 -> UserDetailsService를 상속받은 클래스의 loadUserByUsername을 호출한다.
			
			Authentication auth=authenticationManager.getAuthenticationManager().authenticate(authToken);
			System.out.println("auth : "+auth);
			// 인증 결과 생성된 Authentication 객체에서 필요한 정보를 읽어서 토큰을 만들어서 헤더에 추가한다.
			User user = (User)auth.getPrincipal();
			String token = JWT.create()
							.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*100))//100분짜리 토큰
							.withClaim("username", user.getUsername())
							.sign(Algorithm.HMAC256("edu.pnu.jwt"));
			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer "+token).build();
		}
		catch(Exception e) {
			System.out.println("인증실패");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
