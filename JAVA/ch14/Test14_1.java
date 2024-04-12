package com.ruby.java.ch14;
import java.util.function.Function;
abstract class Geometry{
	abstract double getArea();
}
class Circle extends Geometry{
	int radius;
	Circle(int r){
		this.radius=r;
	}
	public double getArea() {
		double area = Math.pow(radius, 2)*Math.PI;
		return area;
	}
}
class Rectangle extends Geometry{
	int width;
	int height;
	Rectangle(int w, int h){
		this.width=w;
		this.height=h;
	}
	public double getArea() {
		double area = width*height;
		return area;
	}
}
class Triangle extends Geometry{
	int width;
	int height;
	Triangle(int w, int h){
		this.width=w;
		this.height=h;
	}
	public double getArea() {
		double area = width*height/2;
		return area;
	}
}

public class Test14_1 {


	public static void main(String[] args) {
		Function<Geometry, Double> func = (g)->{
			
			double area = g.getArea();
			return area;
		};
		double Area1 = func.apply(new Circle(3));
		double Area2 = func.apply(new Rectangle(3, 4));
		double Area3 = func.apply(new Triangle(3,3));
		System.out.println("원의 넓이 : "+Area1);
		System.out.println("사각형의 넓이 : "+Area2);
		System.out.println("삼각형의 넓이 : "+Area3);


	}

}
