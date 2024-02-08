package edu;

public class Test22 {

	public static void main(String[] args) {
		int a = 12;
		int b = 2;
		char op='+';
		
		switch(op) {
		case '+':
			System.out.println(a+b); break;
		case '-':
			System.out.println(a-b); break;
		case '*':
			System.out.println(a*b); break;
		case '/':
			System.out.println(a/b); break;
		default:
			System.out.println("수식을 다시 입력하세요"); break;
		}
	}
}
