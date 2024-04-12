package com.ruby.java.ch06;

class Count{
	public static int totalCount; //클래스필드
	int count; //인스턴스필드
}

public class CountTest {

	public static void main(String[] args) {
		Count.totalCount++;//클래스필드라서 new를 지정하지 않아도 됨
		System.out.println("실행 시작");
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		//c1, c2, c3이 totalCount를 공유하고 있음(code 메모리영역에서)
		
		c1.count++;
		Count.totalCount++;
		c2.count++;
		Count.totalCount++;
		c3.count++;
		Count.totalCount++;
		
		System.out.println(Count.totalCount + " : "+c1.count);
		System.out.println(Count.totalCount + " : "+c2.count);
		System.out.println(Count.totalCount + " : "+c3.count);
	}

}
