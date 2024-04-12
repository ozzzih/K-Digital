package com.ruby.java.test;

import java.util.Scanner;

public class Test_PrimeNumber3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("자릿수입력: ");
		int num = sc.nextInt();
		int s = (int) Math.pow(10, num);
		int e = (int) Math.pow(10, (num-1));
		for(int i=e; i<s; i++) {
			boolean a =true;
			for(int k=0; k<num; k++) {
				int n = (int) (i / Math.pow(10, (num-k-1)));
				for(int j=2; j<n; j++) {
					if(n%j==0) {
						a=false;//소수가 아니면
						break;
					}	
				}
			}
			
			if(a)
				System.out.println(i);
		}
		sc.close();

	}

}
