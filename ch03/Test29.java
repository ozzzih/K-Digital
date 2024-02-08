package edu;

public class Test29 {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			if((i%2)==0) continue; //조건이 맞으면 밑에꺼 실행 x
			System.out.println(i);
		}

	}

}
