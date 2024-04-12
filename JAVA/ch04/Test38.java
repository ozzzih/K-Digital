package edu;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {
		//난수 생성하기
		Random rnd = new Random();
		int[][] arr = new int[5][5]; //ragged array(열 크기가 다른 행렬)은 코딩 주의가 필요-많이쓰는건 아님
	
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rnd.nextInt(500)+1;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) {
					
					if(arr[i][j]<10)
						System.out.print("00");
					else if(arr[i][j]<100)
						System.out.print("0");
					System.out.print(arr[i][j]);
					
					if((j+1)%5==0)
						System.out.println();
					else
						System.out.print("  ");
				}
				else if(i>j) {
					System.out.print("000  ");
				}
				
			}
			System.out.println("\n");
		}
	}

}
