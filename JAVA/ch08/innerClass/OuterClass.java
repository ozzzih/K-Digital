package com.ruby.java.ch08.innerClass;

public class OuterClass {
	class InstanceClass{
		int a;
		
		void method2() {
			System.out.println("Instance Class : "+a);
		}
	}
	static class StaticClass{
		int b;
		static int c;
		
		void method3(){
			System.out.println("Static Class "+b );
		}
		static void method4() {
			System.out.println("Static Class : "+c);
		}
	}

}
