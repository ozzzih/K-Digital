package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Edu_list;
import edu.pnu.domain.Ncs;
import edu.pnu.repository.ListRepository;
import edu.pnu.repository.NcsRepository;

@Controller
public class MainController {
	@Autowired
	private NcsRepository ncsRepository;
	
	@GetMapping(path="/ncsall")
	public @ResponseBody Iterable<Ncs> getAllNcs(){
		return ncsRepository.findAll();
	}
	
	@Autowired
	private ListRepository listRepo;
	@GetMapping(path="/eduall")
	public @ResponseBody Iterable<Edu_list> getAllEdu(){
		return listRepo.findAll();
	}
}