package com.ruby.java.ch02;

public class Test2 {
	/*
	 int: 정수형
	 float: 실수형
	 */
	public static void main(String[] args) {
		int depositAmount=5000; //카멜표기법3
		float ratio = 0.14f; //
		boolean result = true;
		char gender='F';
		char c='\u0057'; //따옴표는 문자 하나 또는 유니코드, 큰따옴표는 문자열
		String greeting = "good morning"; //String: java에 내부적으로 포함된 클래스 이름
		result=false;
		System.out.println("code= "+c+", gender"+gender);
		System.out.println(result);
		System.out.println(depositAmount);
	}

}
