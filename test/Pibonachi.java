package com.ruby.java.test;

import java.util.Arrays;
import java.util.Scanner;

public class Pibonachi {
	public static int[] pib(int num) {
		int[] result=new int[num];
		result[0]=0; result[1]=1;
		for(int i=2; i<num; i++) {
			result[i]=result[i-2]+result[i-1];
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		int num = sc.nextInt();
		int[]result=pib(num);
		System.out.println(Arrays.toString(result));
	}

}
