package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoggingRunner {
	public void run(ApplicationArguments args) throws Exception{
		log.trace("TRACE 로그 메세지");
		log.debug("DEBUG 로그 메세지");
		log.info("INFO 로그 메세지");
		log.warn("WARN 로그 메세지");
		log.error("ERROR 로그 메세지");
	}
}
