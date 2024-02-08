package com.ruby.java.ch02;

public class Test3 {

	public static void main(String[] args) {
		float exchangeRate = 1236.50f;
		//float exchangeRate = (float)1236.50;//type casting: explicit conversion
		//implicit conversion은 피해야 함. 
		// example
		// int num = 10;
		// long a=num; // type 변환이 명시적이지 않음.
	
		int num = 2147483647;
		String st = "Good Day";
		int numSize = Integer.SIZE;
		System.out.println("numSize= " + numSize);
		long d= 2147483648L;
		int dSize = Long.SIZE;
		System.out.println(d);
		// d변수가 8바이트인지 확인하는 방법은?
		System.out.println("dSize= "+dSize);

	}

}
