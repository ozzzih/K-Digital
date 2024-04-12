package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class MemberDatabase {
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")){
			createTable(con, "member");
			createTable(con, "board");
			PreparedStatement psmt1 = null, psmt2 = null;
			Random rand = new Random();
			psmt1 = con.prepareStatement("insert into Member(username, password, birthyear) values(?,?,?);");
			psmt2 = con.prepareStatement("insert into Board(title, content, id, visitcount) values(?,?,?,?);");
			for (int i=1; i<=5; i++) {
				int birth = rand.nextInt(2000, 2011);
				psmt1.setString(1, "user"+i);
				psmt1.setString(2, "pass"+i);
				psmt1.setInt(3, birth);
				
				int result1 = psmt1.executeUpdate();
				System.out.println("Member 테이블에 "+result1 + "개가 입력되었습니다.");
				for (int j=1; j<=10; j++) {
					int visitcount = rand.nextInt(0, 101);
					
					psmt2.setString(1, "title"+j);
					psmt2.setString(2, "content"+j);
					psmt2.setInt(3, i);
					psmt2.setInt(4, visitcount);
					int result2 = psmt2.executeUpdate();
					System.out.println("Board 테이블에 "+result2 + "개가 입력되었습니다.");
				}
			}
			
			
//			deleteBoard(con);
//			updateBoard(con, 11, "제목수정", "내용수정");
//			deleteMember(con, 5);
//			updateMember(con, 4, "아이디수정", "비번수정", 1998);
			showMember(con);
			showBoard(con);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
	public static boolean createTable(Connection con, String name) {
		Statement st= null;
		
		try {
			st=con.createStatement();
			if(name=="member") {
				st.execute("DROP TABLE Member IF EXISTS");
				st.execute("create table Member("
						+ "id int NOT NULL AUTO_INCREMENT primary key,"
						+ "username varchar(10) NOT NULL,"
						+ "password varchar(10) NOT NULL,"
						+ "birthyear int NOT NULL,"
						+ "regidate date NOT NULL DEFAULT (curdate()))");
			}else {
				st.execute("DROP TABLE Board IF EXISTS");
				st.execute("create table Board("
						+ "num int NOT NULL AUTO_INCREMENT primary key,"
						+ "title varchar(200) NOT NULL,"
						+ "content varchar(2000) NOT NULL,"
						+ "id varchar(10) NOT NULL,"
						+ "postdate date NOT NULL DEFAULT (curdate()),"
						+ "visitcount int DEFAULT 0)");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st!=null) st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public static boolean deleteBoard(Connection con) {
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Board테이블에서 삭제를 원하는 NUM을 입력하세요:");
		int n = sc.nextInt();
		try {
			
			psmt= con.prepareStatement("delete from Board where NUM=?;");
			psmt.setInt(1, n);
			int result = psmt.executeUpdate();
			System.out.println("Board 테이블에 NUM이 "+n+"인 데이터 "+result + "개가 삭제되었습니다.");
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean updateBoard(Connection con) {
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Board테이블에서 수정을 원하는 NUM을 입력하세요:");
		int n = sc.nextInt();
		System.out.print("새로운 title을 입력하세요:");
		String t = sc.next();
		System.out.print("새로운 내용을 입력하세요:");
		String c = sc.next();
		try {
			
			psmt= con.prepareStatement("update Board set title=?, content=? where NUM=? ;");
			psmt.setString(1, t);
			psmt.setString(2, c);
			psmt.setInt(3,  n);
			int result = psmt.executeUpdate();
			System.out.println("Board 테이블에 NUM이 "+n+"인 데이터 "+result + "개가 수정되었습니다.");
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean deleteMember(Connection con) {
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Member 테이블에서 삭제를 원하는 ID를 입력하세요:");
		int i = sc.nextInt();
		try {
			psmt= con.prepareStatement("delete from Member where ID=?;");
			psmt.setInt(1, i);
			int result = psmt.executeUpdate();
			System.out.println("Member 테이블에 ID가 "+i+"인 데이터 "+result + "개가 삭제되었습니다.");
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean updateMember(Connection con) {
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Member테이블에서 수정을 원하는 ID를 입력하세요:");
		int i = sc.nextInt();
		System.out.print("새로운 Username을 입력하세요:");
		String u = sc.next();
		
		System.out.print("새로운 Password를 입력하세요:");
		String p = sc.next();
		System.out.print("새로운 Birthyear를 입력하세요:");
		int b = sc.nextInt();
		try {
			psmt= con.prepareStatement("update Member set USERNAME=?, PASSWORD=?, BIRTHYEAR=? where ID=? ;");
			if(u==null) {
				psmt= con.prepareStatement("update Member set USERNAME=?, PASSWORD=?, BIRTHYEAR=? where ID=? ;");
			}else {
				psmt.setString(1, u);
			}
			psmt.setString(1, u);
			psmt.setString(2, p);
			psmt.setInt(3,  b);
			psmt.setInt(4,  i);
			int result = psmt.executeUpdate();
			System.out.println("Member 테이블에 ID가 "+i+"인 데이터 "+result + "개가 수정되었습니다.");
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean showMember(Connection con ) {
		Statement st= null;
		try {
			System.out.println("<<<<Member 테이블을 출력합니다.>>>>");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from MEMBER;");
			while(rs.next()) { //커서 프로세싱
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i=1; i<rsmd.getColumnCount(); i++) {
					System.out.print(rs.getString(i)+",");
				}
				System.out.println(rs.getString(rsmd.getColumnCount()));
			}	
		}  catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean showBoard(Connection con) {
	
		try {
			System.out.println();
			System.out.println("<<<<Board 테이블을 출력합니다.>>>>");
			Statement st = con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from Board");
			while(rs.next()) { //커서 프로세싱
				if (rs.getInt(1)%5==1)
					System.out.println("--------------------------------------");
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i=1; i<rsmd.getColumnCount(); i++) {
					System.out.print(rs.getString(i)+",");
				}
				System.out.println(rs.getString(rsmd.getColumnCount()));
			}	
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	public static boolean showUser(Connection con, String name) {
		Statement st= null;
		try {
			System.out.println();
			System.out.println("<<<<Board테이블에서 "+name+"인 데이터를 출력합니다.>>>>");
			st=con.createStatement();
			
			}
		}  catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
}
