package com.ruby.java.test;

import java.util.Scanner;

public class Rotation {
	public static double[] rotation(String[] arr, int ang) {
		double[] result=new double[2];
		double rad=Math.toRadians(ang);
		int i1=Integer.parseInt(arr[0]);
		int i2=Integer.parseInt(arr[1]);
		result[0]=Math.cos(rad)*i1-Math.sin(rad)*i2;
		result[1]=Math.sin(rad)*i1+Math.cos(rad)*i2;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 좌표: ");
		String[] arr = sc.next().split(",");
		System.out.println("입력 각도: ");
		int ang = sc.nextInt();
		double[]result=rotation(arr, ang);
		System.out.println("출력 좌표: "+(int)result[0]+", "+(int)result[1]);
		

	}

}
