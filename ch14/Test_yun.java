package com.ruby.java.ch14;

public class Test_yun {
	static void check(int year) {
		if(((year%4==0)&(year%400==0))|((year%4==0)&(year%100!=0))) {
			System.out.println(year+"년은 윤년입니다.");
		}
			
		else {
			System.out.println(year+"년은 평년입니다.");
		}
		
	}
	
	public static void main(String[] args) {	
		check(2024);
		check(2023);
		check(2022);
		check(2021);
	}

}
