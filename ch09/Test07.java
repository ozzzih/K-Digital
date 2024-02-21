package com.ruby.java.ch09;

public class Test07 {

	public static void main(String[] args) {
		String s = "한국,일본,중국,미국,독일,프랑스";
		
		String[] list = s.split(",");
		String[] list2 = s.split(",", 3); //분리할 배열의 개수
		
		for(String item : list) {
			System.out.println(item);
		}
		System.out.println("================================");
		for(String item : list2) {
			System.out.println(item);
		}
		System.out.println("================================");
		
		String email = "purum@rubypaper.co.kr";
		int i = email.indexOf("@"); //'@'의 index
		
		String id = email.substring(0, i);//0부터 i-1까지
		String company = email.substring(i+1); //i+1부터
		System.out.println(id);
		System.out.println(company);
		
	}

}
