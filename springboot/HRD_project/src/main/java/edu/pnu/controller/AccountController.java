package edu.pnu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.dto.AccountDTO;
import edu.pnu.util.AccountFileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/account")
public class AccountController {
	private final AccountFileUtil fileUtil;
	
	@PostMapping("/")
	public Map<String, String> register(AccountDTO accountDTO){
		log.info("rgister: "+accountDTO);
		List<MultipartFile> files = accountDTO.getFiles();
		List<String> uploadFileNames = fileUtil.saveFiles(files);
		accountDTO.setUploadFileNames(uploadFileNames);
		log.info(uploadFileNames);
		return Map.of("RESULT", "SUCCESS");
	}
	
	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){
		return fileUtil.getFile(fileName);
	}
}
