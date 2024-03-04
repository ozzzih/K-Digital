package com.ruby.java.test;

public class TernaryOperator {
	static void aveg(int n1, int n2, int n3) {
		double result; int hap;
		hap=n1+n2+n3;
		result=hap/3;
		if((n1<60)|(n2<60)|(n3<60))
			System.out.println("총계: "+ hap+" 평균: "+result+"=> 과락");
		else {
			if(result<70)
				System.out.println("총계: "+ hap+" 평균: "+result + "=> 과락");
			else
				System.out.println("총계: "+ hap+" 평균: "+result + "=> 통과");
		}
	}

	public static void main(String[] args) {
		aveg(95,65,80);
		aveg(95,65,55);
	}
}
