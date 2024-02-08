package edu;
import java.util.Scanner;
public class Test31_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		int num = sc.nextInt();
		boolean flag=false;
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				flag=true;
				break;
			}
		}
		System.out.println(flag?"소수가 아닙니다.":"소수입니다.");
		sc.close();
	}
}
