/**
 * 
 */
package edu.pnu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	public List<Board> findByTitle(String keyword);
	public List<Board> findByContentContaining(String searchKeyword);
	public List<Board> findByTitleContainingOrContentContaining(String title, String content);
	public List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	public List<Board> findByTitleContainingAndCntGreaterThan(String title, Integer cnt);
	public List<Board> findByCntBetweenOrderBySeq(Integer cnt1, Integer cnt2);
	public List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	public Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	@Query("SELECT b FROM Board b "
		+	"WHERE b.title like %:searchKeyword% "
		+   "ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String wearchKeyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b "
			+	"WHERE b.title like %?1% "
			+   "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query(value="select seq, title, writer, createdate "
			+ "from board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
}
