package com.ruby.java.ch06;

public class Armor {
	private String name; //현재 클래스 내부에서만 접근 가능
	private int height; //여기까지만 쓰고 Source->Generate Getter and Setter 클릭하면 아래 코드 자동 완성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
