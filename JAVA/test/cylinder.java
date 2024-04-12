package com.ruby.java.test;

public class cylinder {

	public static void main(String[] args) {
		double radius=3.1;
		int height=2;
		double volume=getVolume(radius, height);
		
		double area=getArea(radius, height);
		System.out.println("원기둥의 부피: "+volume);
		System.out.println("원기둥의 겉넓이: "+area);
	}	
	static double getVolume(double r, int h) {
		return Math.pow(r, 2)*Math.PI*h;
	}
	static double getArea(double r, int h) {
		return 2*Math.pow(r, 2)*Math.PI+2*Math.PI*r*h;
	}

	

}
