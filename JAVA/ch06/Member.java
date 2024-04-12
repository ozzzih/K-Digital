package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;	
		}

	public Member() {
		this("guest");
	}
	
	public Member(String name) {
		this(name, 0);
	}
	
	public Member(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy", 20);
		System.out.println("m1: "+m1);//오버라이드 했기 때문에 바로 toString함수 호출
		System.out.println("m2: "+m2);
		System.out.println("m3: "+m3);
	}

}
