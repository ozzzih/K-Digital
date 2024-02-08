package edu;

import java.util.Random;

public class Test38_test {

	public static void main(String[] args) {
		int A[][] = new int[3][4];//난수 입력
		int B[][] = new int[4][5];//난수 입력
		int C[][] = new int[3][5];
		int D[][] = new int[3][4];//난수 입력
		int E[][] = new int[3][4];
		int F[][] = new int[4][3];
		//C=A*B
		//E=A+B
		//F=A의 전치 행렬
		//난수 생성하기
		Random rnd = new Random();
		
		// 행렬 만들기
		// 3*4행렬 만들기
		for(int i=0; i<A.length; i++) { //3
			for(int j=0; j<A[i].length; j++) { //4
				A[i][j] = rnd.nextInt(10)+1;
				D[i][j] = rnd.nextInt(10)+1;
			}
		}
		// 4*5행렬 만들기
		for(int i=0; i<B.length; i++) { //4
			for(int j=0; j<B[i].length; j++) { //5
				B[i][j] = rnd.nextInt(10)+1;
			}
		}
		//끝
		
		
		
		System.out.println("*****[A]****");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				if(A[i][j]<10)
					System.out.print("0");
				System.out.print(A[i][j]+"   ");
				if((j+1)%A[i].length==0)
					System.out.println();
				
			}
		}
		System.out.println("*****[B]*****");
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B[i].length; j++) {
				if(B[i][j]<10)
					System.out.print("0");
				System.out.print(B[i][j]+"   ");
				if((j+1)%B[i].length==0)
					System.out.println();
				
			}
		}
		System.out.println("#######[문제 1]########");
		//문제: c=a*b
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				for(int k=0; k<A[0].length; k++)
					C[i][j]+=A[i][k]*B[k][j];
			}
		}
		System.out.println("****[곱셈의 결과: C]****");
		for(int i=0; i<C.length; i++) {
			for(int j=0; j<C[i].length; j++) {
				if(C[i][j]<100)
					System.out.print("0");
				System.out.print(C[i][j]+"   ");
				if((j+1)%C[i].length==0)
					System.out.println();
				
			}
		}
		System.out.println("#######[문제 2]########");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {

				E[i][j]+=A[i][j]+B[i][j];
			}
		}
		System.out.println("****[덧셈의 결과: E]****");
		for(int i=0; i<E.length; i++) {
			for(int j=0; j<E[i].length; j++) {
				if(E[i][j]<10)
					System.out.print("0");
				System.out.print(E[i][j]+"   ");
				if((j+1)%E[i].length==0)
					System.out.println();
			}
		}
		System.out.println("#######[문제 3]########");
		System.out.println("****[전치행렬 결과: F]****");
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				F[j][i]=A[i][j];
			}
		}
		for(int i=0; i<F.length; i++) {
			for(int j=0; j<F[i].length; j++) {
				if(F[i][j]<10)
					System.out.print("0");
				System.out.print(F[i][j]+"   ");
				if((j+1)%F[i].length==0)
					System.out.println();
			}
		}
		
	}
}
