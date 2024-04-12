package com.ruby.java.test;

public class GugudanTest {

	public static void main(String[] args) {
		Gugudan ggd = new Gugudan();
		
		ggd.print(2);
		System.out.println("-".repeat(15));
		ggd.print(3);
		System.out.println("-".repeat(15));
		ggd.print(4);
		System.out.println("-".repeat(15));
		ggd.printHorizontal();
		System.out.println("-".repeat(15));
		ggd.printcolumn(3);
		System.out.println("-".repeat(15));
		ggd.printcolumn(4);
		System.out.println("-".repeat(15));
		ggd.printcolumn(5);
		System.out.println("-".repeat(15));
		ggd.printcolumn(6);
		System.out.println("End");
		System.out.println("End");
	}

}
