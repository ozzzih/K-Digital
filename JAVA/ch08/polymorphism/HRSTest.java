package com.ruby.java.ch08.polymorphism;

abstract class Employee{
	String name;
	int salary;
	
	
	public abstract double calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee{
	int annual_sales;//연간 판매 실적
	public double calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
		return 500;
	}
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee{
	int num_project; //컨설팅 참여 수 
	public double calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 팀 성과 수당");
		return 800;
	}
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

class Manager extends Employee{
	int num_team; //관리 팀 수 
	public double calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
		return 1000;
	}
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
	
	
}

class Director extends Manager{
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}
public class HRSTest {
	public static void calcTax(Employee e) { // 조상 클래스로 함수를 선언
		double tax=e.calcSalary()*0.1;
		System.out.println("소득세를 계산합니다. 세금="+tax);
	}

	public static void main(String[] args) {
		
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		System.out.println(s.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		Salesman s2 = s;
		System.out.println(s2.toString());
		HRSTest.calcTax(s);
		HRSTest.calcTax(c);
		HRSTest.calcTax(d);
		if(s.equals(c)) {
			System.out.println("동일한 객체입니다.");
		}else {
			System.out.println("서로 다른 객체입니다.");
		}


	}

}
