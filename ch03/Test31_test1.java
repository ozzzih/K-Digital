package edu;
import java.util.Scanner;
public class Test31_test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("자릿수입력: ");
		int num = sc.nextInt();

		
		for(int i=(int)Math.pow(10, (num-1)); i<Math.pow(10, num); i++) {
			boolean a =true;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					a=false;//소수가 아니면
					break;
				}	
			}
			if(a)
				System.out.println(i);
		}
		sc.close();
	}
	
}
