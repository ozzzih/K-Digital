package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDao {
	public static Connection getConnection() { 
		Connection conn = null;
		try {
			String url="jdbc:h2:tcp://localhost/~/.h2/sqlprg";
			String username = "sa";
			String password = "abcd ";
			
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection(url, username, password );
			
			System.out.println("연결 성공");
			con.close();
		}
		catch(Exception e) {
			System.out.println("연결 실패");
		}
		return conn;
	}
}
