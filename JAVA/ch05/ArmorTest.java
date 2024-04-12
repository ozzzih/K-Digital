package com.ruby.java.ch05;


public class ArmorTest{
	public static void main(String[] args) {
		System.out.println("1");
		String num = takeoff(6,7);
		System.out.println(num);
		System.out.println("2");
	}
	
	//int, String, long, boolean, char
	static String takeoff(int num1, int num2) {
		System.out.println("takeoff");
		
		return num1 + "--->" + num2;
	}
}
