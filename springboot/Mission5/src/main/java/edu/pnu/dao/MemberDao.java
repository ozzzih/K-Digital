package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao {
	@Autowired
	private DataSource dataSource;
	
	public List<MemberVO> getAllMember(){
		Statement st=null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = dataSource.getConnection().createStatement();
			rs=st.executeQuery("select * from member");
			while(rs.next()) {
				MemberVO m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("PASS"))
						.name(rs.getString("NAME"))
						.regidate(rs.getDate("regidate"))
						.build();
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(st!=null) st.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
		
	}
	public MemberVO getMember(Integer id) {
		PreparedStatement ps=null;
		ResultSet rs = null;
		MemberVO m =null;
		try {
			ps=dataSource.getConnection().prepareStatement("select * from member where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();			
			
			
			if(rs.next()) {
				m=MemberVO.builder().id(rs.getInt("id")).build();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null) ps.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return m;
	}
	public MemberVO addMember(MemberVO memberVO) {
		if (getMember(memberVO.getId()) != null)
			return null;
		memberVO.setRegidate(new Date());
		PreparedStatement ps=null;
		
		try {
			ps=dataSource.getConnection().prepareStatement("insert into member (pass, name) values (?, ?);");
			
			ps.setString(1, memberVO.getPass());
			ps.setString(2, memberVO.getName());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return memberVO;
	}
	
	public int updateMembers(MemberVO memberVO) {
		Integer i = memberVO.getId();
		MemberVO m = getMember(i);
		if (m == null)
			return 0;
		PreparedStatement ps=null;
		int rs=0;
		try {
			ps=dataSource.getConnection().prepareStatement("UPDATE member SET pass=?, name=? WHERE id = ?;");
			ps.setString(1, memberVO.getPass());
			ps.setString(2, memberVO.getName());
			ps.setInt(3, i);
			rs=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rs;
	}
	
	public int removeMember(Integer id) {
		PreparedStatement ps=null;
		int rs=0;
		try {
			ps=dataSource.getConnection().prepareStatement("DELETE FROM member WHERE ID=?;");
			ps.setInt(1, id);
			rs=ps.executeUpdate();
		} catch(Exception e) {
			return rs;
		}
		return rs;
	}
	
}
