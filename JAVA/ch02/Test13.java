package com.ruby.java.ch02;

public class Test13 {

	public static void main(String[] args) {
		byte a = 0b00001001; //2진수표현은 0b로 시작
		byte b = 0b00100010;
		int c = a^b;//00110011 : XOR연산자
		System.out.println(Integer.toBinaryString(a));
		System.out.println("a=" + a);
		System.out.println(Integer.toBinaryString(b));
		System.out.println("b=" + b);
		System.out.println(Integer.toBinaryString(c));
		int f = 12;
		int h = f << 1; //왼쪽으로 1비트 이동
		int g = (~f) + 1; //two's complement
		System.out.println("c="+c);
		System.out.println("h="+h);
		System.out.println("g="+g);

	}

}
