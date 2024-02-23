package com.ruby.java.ch11;

public class Test02 {
	public static void main(String[]  args) {
		System.out.println("시작");
		Test02_01();
	}
	private static void Test02_01(){
		try {
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			String s = null;
			s.length();
			
		}catch(Exception e) {
			System.out.println("오류 발생");
			return;
		} finally {
			System.out.println("OK");
		}
		System.out.println("4");
	}
}


