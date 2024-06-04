package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Edu_list;

public interface ListRepository extends JpaRepository<Edu_list, String>{

}
