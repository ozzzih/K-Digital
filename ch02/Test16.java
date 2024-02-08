package com.ruby.java.ch02;

public class Test16 {

	public static void main(String[] args) {
		byte a = 23;
		int b = a;
		//a=b;//error
		//해결법
		//a=(byte)b;//explicit casting: 타입변환을 대놓고
		System.out.println(b);
		byte i=10;
		byte j=20;
		//byte k=i+j;//error: 더하기는 결과를 int로 내는 효과=>정수에 대한 operator
		byte k = (byte)(i+j); //type casting
		System.out.println(k);
		
		
	}

}
