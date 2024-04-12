package chap05_재귀알고리즘;

import java.util.Scanner;

public class nfactorial {
	static int factorial(int n) {
		if (n>0)
			return n*factorial(n-1);
		else
			return 1;
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		System.out.println("입력값:");
		int x = std.nextInt();
		System.out.println(x+"팩토리얼 값은"+factorial(x));

	}

}
