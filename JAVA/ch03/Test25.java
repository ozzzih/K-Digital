package edu;
import java.util.Scanner;
public class Test25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Num: ");
		int num = sc.nextInt();
		
		int sum1=0;
		int sum2=0;
		for(int i = 0; i<num; i++) {
			if ( i%2==0) {
				sum1+=i;
			} else {
				sum2+=i;
			}
		}
		System.out.println("짝수합: "+sum1);
		System.out.println("홀수합: "+sum2);
	}
}
