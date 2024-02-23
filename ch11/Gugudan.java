package com.ruby.java.ch11;

public class Gugudan {

	public void print(int i) {
		System.out.println("["+i + "단]");
		for(int j=1; j<10; j++) {
			System.out.println(i+"*"+j+"="+(i*j)+"\t");
		}
		System.out.println(i+"단 구구단 출력 끝");
	}
	public void printall() {
		for(int j=1; j<10; j++) {
			for(int i=2; i<10; i++) {
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.print("\n");
		}
	}
	public void print3() {
		for(int k=0; k<3; k++) {
			for(int j=1; j<10; j++) {
				for(int i=2; i<5; i++) {
					System.out.print((k*3+i)+"*"+j+"="+(i*j)+"\t");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
		
	}
}
