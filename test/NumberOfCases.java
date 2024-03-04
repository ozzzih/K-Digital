package com.ruby.java.test;

import java.util.Scanner;

public class NumberOfCases {
	static String sumCase(int n) {
		
		if(n==10) {
			System.out.println("(1,1,1)");
		}
		else {
			for(int i = 1 ; i<10; i++) {
				int a = n-10-(2*i);
				if(a==0) {
					System.out.println("("+(i+1)+", 1, 1)");
				}
				else {
					for(int j=1; j<10; j++) {
						int b=a-(3*j);
						if((b==0)) {
							System.out.println("("+(i+1)+", "+(j+1)+", 1)");
						}
						for(int k=1; k<10; k++) {
							int c=b-(5*k);
							if((c==0)) {
								System.out.println("("+(i+1)+", "+(j+1)+", "+(k+1)+")");
								break;
							}
						}
					}
				}
				
			}
		}
		
		return "끝";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("10~100사이의 임의의 값을 입력하세요: ");
		int num = sc.nextInt();
		if(num<10 ||num>100) {
			System.out.println("!입력 값이 틀렸습니다!");
			System.out.println("10~100사이의 임의의 값을 입력하세요: ");
			num = sc.nextInt();
		}
		System.out.println(sumCase(num));
		
		

	}

}
