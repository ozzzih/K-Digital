package com.ruby.java.ch04;

import java.util.Random;


public class Test_행렬계산 {	/*
	 * 행렬 덧셈, 곱셈 연산 메소드 정의
	 * 1차버젼: 덧셈후 바로 출력
	 * 2차버젼: 덧셈후 return 값으로 결과 행렬 반환
	 */
	
	static void showMatrix(int [][]X) {
		//2차원 모습으로 출력
		for(int i=0; i<X.length; i++) {
			for(int j=0; j<X[i].length; j++) {
				if(X[i][j]<10)
					System.out.print("0");
				System.out.print(X[i][j]+"   ");
				if((j+1)%X[i].length==0)
					System.out.println();
			}
		}
	}
	
	static int[][] multiplyMatrix(int [][]A, int [][]B){
		int C[][]=new int[A.length][B[0].length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				for(int k=0; k<A[0].length; k++)
					C[i][j]+=A[i][k]*B[k][j];
			}
		}
		return C;
    }
    
    static int[][] addMatrix(int [][]A, int [][]B){
    	int[][] C=new int[A.length][A[0].length];
        for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				C[i][j]=A[i][j]+B[i][j];
			}
		}
		return C;
    }
    
    static int[][] transposeMatrix(int [][]A){
    	int B[][]=new int[A[0].length][A.length];
    	for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				B[j][i]=A[i][j];
			}
		}
		return B;
    }
    
    static void getData(int[][] A){
    	Random rnd = new Random();
    	
    	for(int i=0; i<A.length; i++) { //3
			for(int j=0; j<A[i].length; j++) { //4
				A[i][j] = rnd.nextInt(10)+1;
			}
		}
    }
    
	public static void main(String[] args) {
		int A[][] = new int[3][4];//난수 입력
		int B[][] = new int[3][4];
		int C[][] = new int[3][4];
		int D[][] = new int[3][5];
		int E[][] = new int[4][5];//난수입력
		int F[][] = new int[4][3];
		
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		getData(B);getData(C);getData(E);
		A = addMatrix(B, C);
		System.out.println("***행렬B***");
		showMatrix(B);
		System.out.println("***행렬C***");
		showMatrix(C);
		System.out.println("**더하기 결과***");
		showMatrix(A);
		System.out.println("=====================================");
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = multiplyMatrix(B,E);
		System.out.println("***행렬B***");
		showMatrix(B);
		System.out.println("***행렬E***");
		showMatrix(E);
		System.out.println("**곱셈결과***");
		showMatrix(D);
		System.out.println("=====================================");
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = transposeMatrix(B);
		System.out.println("***행렬B***");
		showMatrix(B);
		System.out.println("***행렬F***");
		showMatrix(F);

	}



	
}
