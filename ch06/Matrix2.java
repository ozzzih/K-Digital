package com.ruby.java.ch06;

import java.util.Random;
import java.util.Arrays;
public class Matrix2
{
    private int s; 
    private int r; 
    private int c;
    private int x[][];
    private int[] array;
    
    public Matrix2(int[] array, int s, int r, int c){
        this.s=s;
        this.r=r;
        this.c=c;
        this.x = new int[r][c];
        this.array = array;
        
        //행렬에 대입
        for(int i=0; i<r; i++) { //3
			for(int j=0; j<c; j++) { //4
			    int idx = i*c+j;
		        x[i][j]=array[s+idx];
			}
		}
    }
    public void print(){
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(x[i][j]<10)
					System.out.print("0");
				System.out.print(x[i][j]+"   ");
				if((j+1)%c==0)
					System.out.println();
			}
		}
    }
    public static Matrix2 multiple(Matrix2 a, Matrix2 b){
        int array[]=a.array;
        Matrix2 x = new Matrix2(array, 0, a.r, b.c);
        for(int i=0; i<a.r; i++) {
			for(int j=0; j<b.c; j++) {
				for(int k=0; k<a.c; k++){
				    x.x[i][j]+=a.x[i][k]*b.x[k][j];
				}
					
			}
		}
		return x;
    }
    
    public static Matrix2 sum(Matrix2 a, Matrix2 b){
        int array[]=a.array;
        Matrix2 x = new Matrix2(array, 0, a.r, a.c);
        for(int i=0; i<a.r; i++) {
			for(int j=0; j<a.c; j++) {

				x.x[i][j]=a.x[i][j]+b.x[i][j];
			}
		}
		return x;
    }
    
	public static void main(String[] args) {
	    int[] array = new int[24];
	    //난수 생성하기
		Random rnd = new Random();
		for(int i=0; i<24; i++){
		    array[i] = rnd.nextInt(50)+1; //0발생 제외
		}
		System.out.println("배열 생성: "+Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("오름차순 정렬: "+Arrays.toString(array));
		
		Matrix2 mA1 = new Matrix2(array, 0, 3, 4);
        Matrix2 mB1 = new Matrix2(array, 12, 3, 4);
        System.out.println("A1행렬");
        mA1.print();
        System.out.println("B1행렬");
        mB1.print();
        Matrix2 mC1 = Matrix2.sum(mA1, mB1);
        System.out.println("A1+B1 결과");
        mC1.print();
        
        // 행렬곱 s, r, c
        Matrix2 mA2 = new Matrix2(array, 0, 3, 4);
        Matrix2 mB2 = new Matrix2(array, 12, 4, 3);
        System.out.println("A2행렬");
        mA1.print();
        System.out.println("B2행렬");
        mB1.print();
        System.out.println("A2*B2 결과");
        Matrix2 mC2 = Matrix2.multiple(mA2, mB2);
        mC2.print();


	}
}
