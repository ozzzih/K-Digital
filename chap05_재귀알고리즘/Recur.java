package chap05_재귀알고리즘;

import java.util.Scanner;

public class Recur {
	static void recur(int n) {
		IntStack s = new IntStack(n);
		while (true) {
			if(n>0) {//체스판의 다음 행에 퀸을 배치할 수 있으면
				s.push(n);
				n=n-1;
				continue;
			}
			if(s.isEmpty()!=true) {
				n=s.pop();
				//pop()한 위치를 사용해서 다음 열을 조사하고 더 이상 없으면 이전 행으로 돌아가기
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
		}
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System. in);
		System.out.println("정수 입력:");
		int x = std.nextInt();
		recur(x);
	}

}
