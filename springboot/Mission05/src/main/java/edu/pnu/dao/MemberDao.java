package edu.pnu.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;


public class MemberDao {
	private Connection conn;
	
	private String url="jdbc:h2:tcp://localhost/~/.h2/sqlprg";
	private String username = "sa";
	private String password = "abcd";
	
	public MemberDao() { 
		
		try {			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DAO생성");
		}
		catch(Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		
	}
	
	public List<MemberVO> getAllMember(){
		Statement st=null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs=st.executeQuery("select * from member");
			while(rs.next()) {
				MemberVO m = MemberVO.builder().id(rs.getInt("id")).build();
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
			ps=conn.prepareStatement("select * from member where id=?");
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
	
}
