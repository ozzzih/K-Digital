package com.ruby.java.test;
class Member{
	String username;
	String password;
	String role;
	boolean enabled;
	public void toStirng() {
		System.out.println("Member의 username은 "+this.username+", password는 "+this.password+" role은 "+this.role+" enabled는 "+this.enabled);
	}
	Member(String name, String pw, String role, boolean enabled){
		this.username=name;
		this.password=pw;
		this.role=role;
		this.enabled=enabled;
	}
}
public class Memberclass {

	public static void main(String[] args) {
		Member[] m = new Member[10];
		m[0]=new Member("오지현", "abcd", "사용자", true);
		m[1]=new Member("오지현", "adfg", "관리자", true);
		m[2]=new Member("오지현", "awerd", "사용자", true);
		m[3]=new Member("오지현", "qwed", "관리자", true);
		m[4]=new Member("오지현", "dfgcd", "사용자", true);
		m[5]=new Member("오지현", "bssd", "사용자", true);
		m[6]=new Member("오지현", "werd", "사용자", true);
		m[7]=new Member("오지현", "zsdfd", "사용자", true);
		m[8]=new Member("오지현", "ertcd", "사용자", true);
		m[9]=new Member("오지현", "hcd", "사용자", true);
		
		for(Member s : m) {
			s.toStirng();
		}

	}

}
