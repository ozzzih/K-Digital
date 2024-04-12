package com.ruby.java.ch09;

public class Test05 {

	public static void main(String[] args) {
		String address[] = {"경기도 남양주 별내동", "서울시 영등포구 당산동",
							"충남 천안시 서북구", "서울시 양천구 옥동",
							"서울시 송파구 서촌동", "전북 부안군 부안읍"
							};
		System.out.println("1");
		for(int i =0; i<address.length; i++) {
			if(address[i].indexOf("서울시")!=-1) { //'서울시'를 포함하고 있을때-처음부터 찾음
				System.out.println(address[i]);
			}
		}
		System.out.println("2");
		for(int i=0; i<address.length; i++) {
			if(address[i].lastIndexOf("별내동")!=-1) {//'별내동'을 포함하고 있을때-마지막부터 찾음
				System.out.println(address[i]);
			}
		}
		System.out.println("3");
		for(int i=0; i<address.length; i++) {
			if(address[i].startsWith("서울시")) {//'서울시'로 시작하는 문자열만
				System.out.println(address[i]);
			}
		}
		System.out.println("4");
		for(int i=0; i<address.length; i++) {
			if(address[i].endsWith("별내동")) {//'별내동'으로 끝나는 문자열만
				System.out.println(address[i]);
			}
		}

	}

}
