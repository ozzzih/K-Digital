package edu;

import java.util.Random;

public class Test37 {

	public static void main(String[] args) {
		//난수 생성하기
		Random rnd = new Random();
		int[] score = new int[20];
		for(int i = 0; i<score.length; i++) {
			score[i] = rnd.nextInt(30)+1;
		}
		
		for(int j=0; j<score.length; j++) {
			if(j%4==0)
				System.out.println();
			if(score[j]<10)
				System.out.print(" ");
			System.out.print(score[j]+" ");
			
		}
		int sum = 0, max = 0, min = 999;
		double avg = 0.0;

		
		for(int i = 0; i<score.length; i++) {
			sum += score[i];
			if(max<score[i])
				max = score[i];
			if(min>score[i])
				min = score[i];
		}
		
		avg = sum /score.length;
		System.out.println();
		System.out.println("*************");
		System.out.println("총 점 : "+sum);
		System.out.println("평 균 : "+avg);
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
		System.out.println("*************");
	}

}
