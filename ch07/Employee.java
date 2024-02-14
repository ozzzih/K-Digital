package com.ruby.java.ch07;

public class Employee extends Person{
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public String toString() {
		return super.toString()+" : "+dept;
	}
	public Employee() {
		System.out.println("Employee 생성자 실행!");
	}
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept=dept;
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}
}
