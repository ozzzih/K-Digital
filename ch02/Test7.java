package com.ruby.java.ch02;

public class Test7 {

	public static void main(String[] args) {
		short e = 10;
		int f = -e;
		int a = 10;
		int b,c = 0;
		b = ++a; //현재 a값에 +1하고 b에 주기
		System.out.println("b= "+b+", a= "+a);
		c = a++; //현재 a값을 c에게 주고 a값을 +1
		System.out.println("c= "+c+", a= "+a);

	}

}
