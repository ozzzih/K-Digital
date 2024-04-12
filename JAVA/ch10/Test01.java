package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("북경"); list.add("상해"); 
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		list.add("런던"); list.add("로마"); list.add("방콕"); 
		list.add("북경"); list.add("도쿄"); list.add("서울"); 
		System.out.println("1 : "+list.toString());
		list.add(1,"LA"); //1번째 자리에 'LA'를 넣겠다.
		print(2, list); //내가 만든 함수
		
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));
		
		list.remove("LA"); print(5, list);
		
		list.remove(2); print(6, list); //두번째꺼 삭제해서 출력
		
		System.out.println("7 : " + list.contains("LA")); //LA가 포함되어있냐
		
		//매우 중요
		Object obj[]=list.toArray(); //toArray괄호안이 빈칸이면 Object 타입의 배열로 반환		
		System.out.println("8 : "+ Arrays.toString(obj));
		// <T> T[] toArray(T[] a) - 해석할 수 있어야 한다 
		String cities[]=new String[0];
		cities = list.toArray(cities);//cities의 타입(String)으로 변환하여 배열에 저장
		//toArray([T[] a)의 return type은 T[]
		System.out.println("9 : "+ Arrays.toString(cities));
		
		list.clear(); print(10, list);//Arraylist의 모든 데이터를 삭제
		
		System.out.println("11: "+list.isEmpty());//모두 비었냐는 의미
		
		list.add("파리");
		list.add("방콕");
		list.add("LA");
		
		// Arrays 클래스의 static <T> List<T> asList(T... a) *** 중요
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");
		print(12, list2);
		
		list.addAll(list2); print(13, list);//콜렉션 합체
		
		System.out.println("14 : "+list.containsAll(list2)); //list에 list2가 포함되었는지 여부
		
		list.retainAll(list2); print(15, list); //list에서 list2내용만 남기고 모두 삭제
		
		list.removeAll(list2); print(16, list);//list에서 list2내용모두 삭제
		
	}
	static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);//스트링으로 타입 변환후 toString() 호출하여 실행
		//System.out.println(n + " : " + list.toString());//동일한 효과
	}

}
