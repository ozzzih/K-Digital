package com.ruby.java.ch06;

import java.util.Random;

public class Matrix {
	int A[][] = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
	};
	int B[][] = {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{10,11,12}
	};
	int C[][] = new int[3][3];
	
	

	public static void main(String[] args) {
		Matrix x = new Matrix();

		
		for(int i=0; i<x.A.length; i++) {
			for(int j=0; j<x.B[0].length; j++) {
				for(int k=0; k<x.A[0].length; k++)
					x.C[i][j]+=x.A[i][k]*x.B[k][j];
			}
		}
		
		System.out.println("****[곱셈의 결과: C]****");
		for(int i=0; i<x.C.length; i++) {
			for(int j=0; j<x.C[i].length; j++) {
				if(x.C[i][j]<100)
					System.out.print("0");
				System.out.print(x.C[i][j]+"   ");
				if((j+1)%x.C[i].length==0)
					System.out.println();
				
			}
		}
	}
}
	
		
		
		
		
		
