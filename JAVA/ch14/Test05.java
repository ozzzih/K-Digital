package com.ruby.java.ch14;
interface NumberFunc{
	int func(int n);
}

public class Test05 {
	public static void main(String[] args) {
		NumberFunc sum = (n)->{
			int result = 0;
			for(int i = 0; i<=n; i++) {
				result += i;
			}
			return result;
		};
		//짝수
		NumberFunc sum1 = (n)->{
			int result = 0;
			for(int i = 0; i<=n; i+=2) {
					result += i;
			}
			return result;
		};
		
		//홀수
		NumberFunc sum2 = (n)->{
			int result = 0;
			for(int i = 1; i<=n; i+=2) {
					result += i;		
			}
			return result;
		};
		
		System.out.println("1부터 100까지의 짝수의 합 : "+sum1.func(100));
		System.out.println("1부터 100까지의 홀수의 합 : "+sum2.func(100));
		System.out.println("1부터 10까지의 합 : "+sum.func(10));
		System.out.println("1부터 100까지의 합 : "+sum.func(100));
	}
}
