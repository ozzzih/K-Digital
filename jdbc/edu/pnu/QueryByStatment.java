package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class QueryByStatment {
	public static void query(Connection con, String table) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Population from country where Code='KOR'");
		while(rs.next()) { //커서 프로세싱
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for (int i=1; i<rsmd.getColumnCount(); i++) {
				System.out.print(rs.getString(i)+",");
			}
			System.out.println(rs.getString(rsmd.getColumnCount()));
		}	
	}

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		String username = "user";
		String password = "1234";
		try (Connection con= DriverManager.getConnection(url, username, password)){
			query(con, "city");
			query(con, "country");
			query(con, "countrylanguage");
			
		}catch(Exception e) {
			System.out.println("연결 실패: "+e.getMessage());
			
		}
		System.out.println("done");
	}
}