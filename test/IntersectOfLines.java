package com.ruby.java.test;

public class IntersectOfLines {
	public int x1, y1, x2, y2, x3, y3, x4, y4;
	public double[] GetIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		this.x1=x1; this.x2=x2; this.x3=x3; this.x4=x4;
		this.y1=y1; this.y2=y2; this.y3=y3; this.y4=y4;
		double[]x=new double[2];
		x[0]=((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
		x[1]=((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
		return x;
	}
	public void printInterSect(double []x) {
		System.out.println("("+x1+", "+y1+") - ("+x2+", "+y2+"), ("+x3+", "+y3+") - ("+x4+", "+y4+") : ("+x[0]+", "+x[1]+")");
	}

	public static void main(String[] args) {
		IntersectOfLines I = new IntersectOfLines();
		I.printInterSect(I.GetIntersect(5, 3, 2, 1, 5, 2, 3, 1));
	}
}
