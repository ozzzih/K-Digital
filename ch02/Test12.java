package com.ruby.java.ch02;

public class Test12 {

	public static void main(String[] args) {
		int a = 017;
		int b = 0xf;//16진법 포맷: 0x
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		String hexa = Integer.toHexString(b);
		System.out.println("hexa = " + hexa);

	}

}
