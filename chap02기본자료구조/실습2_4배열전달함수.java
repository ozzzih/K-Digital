package chap02기본자료구조;

import java.util.Random;
public class 실습2_4배열전달함수 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
	}
	static void showData(int[]data) {
		for (int num: data) {
			System.out.print(num+" ");
		}
	}
	public static void inputData(int []data) {//교재 63 - 난수의 생성
		Random rand = new Random();
		for (int i=0; i<data.length; i++)
			data[i]=rand.nextInt(100);
	}
	static int findMax(int []items) {
		int max=items[0];
		for(int i=0; i<items.length; i++)
			if(items[i]>max) max=items[i];
		return max;
	}
	static boolean findValue(int []items, int value) {
		//items[]에 value 값이 있는지를 찾는 알고리즘 구현
		boolean result=false;
		for(int i=0; i<items.length; i++)
			if(items[i]==value) result=true;
		return result;
	}

}
