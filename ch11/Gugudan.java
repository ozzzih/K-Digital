package com.ruby.java.ch11;

public class Gugudan {

	public void print(int i) {
		System.out.println("["+i + "단]");
		for(int j=1; j<10; j++) {
			System.out.println(i+"*"+j+"="+(i*j)+"\t");
		}
		System.out.println(i+"단 구구단 출력 끝");
	}
	public void printHorizontal() {
		for(int j=1; j<10; j++) {
			for(int i=2; i<10; i++) {
				if((i*j)<10)	
					System.out.print(i+"*"+j+"="+"0"+(i*j)+"\t");
				else
					System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.print("\n");
		}
	}
	public void printcolumn(int l) {

		for(int k=0; k<l; k++) {
			for(int j=1; j<10; j++) {
				for(int i=2; i<l+2; i++) {
					if((k*l+i)>9)
						break;
					else
						System.out.print((k*l+i)+"*"+j+"="+(i*j)+"\t");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}

	}
}
