package edu.pnu.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Edu_list;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private ListRepository listRepo;
	
	//@Autowired
	//private InfoRepository infoRepo;
	
	@Test
	public void testManyToOneSelect() {
		Edu_list edu_list = listRepo.findById("ACG20233000926514").get();
		System.out.println("[ "+edu_list.getTITLE()+"]");
		System.out.println("address: "+edu_list.getEdu_info().getADDRESS_info());
		
	}
}
