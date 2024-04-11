package edu.pnu;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Code:");
		String code = sc.next();
		Statement st=null;
		ResultSet rs=null;
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "user", "1234")){
			st=con.createStatement();
			rs=st.executeQuery("Select Name, Population from city "+
							"where CountryCode="+code+" order by population desc");
			while(rs.next()) {
				System.out.println(rs.getString("Name")+","+rs.getInt("Population"));
			}
		}catch(Exception e) {
			try {
				st.close();
				rs.close();				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		sc.close();
	}
}
