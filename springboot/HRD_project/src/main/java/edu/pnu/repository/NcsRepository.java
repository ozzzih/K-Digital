package edu.pnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Ncs;

public interface NcsRepository extends JpaRepository<Ncs, Long>{
//	List<Ncs> findAllByLarge(String large);
//	List<Ncs> findAllByMid(String mid);
//	List<Ncs> findAllBySmall(String small);
//	List<Ncs> findAllBySSmall(String ssmall);
}