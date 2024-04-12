package com.ruby.java.ch07;

public class Professor extends Person{
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String toString() {
		return this.getName() + " : "+this.getAge()+" : "+subject;
	}
	public Professor() {
		System.out.println("Professor 생성자 실행!");
	}
	public Professor(String name, int age, String subject) {
		super(name, age);
		this.subject=subject;
		System.out.println("Professor(name, age, subject) 생성자 실행!");
	}
}
