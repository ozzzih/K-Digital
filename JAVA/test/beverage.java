package com.ruby.java.test;
abstract class Drinks{
	abstract void drink();
}
class Juice extends Drinks{
	void drink(){
		System.out.println("주스를 마십니다.");
	}
}
class Coffee extends Drinks{
	void drink() {
		System.out.println("커피를 마십니다.");
	}
	
}
class Beer extends Drinks{
	void drink() {
		System.out.println("맥주를 마십니다.");
	}
}
class Water extends Drinks{
	void drink() {
		System.out.println("물을 마십니다.");
	}
}

public class beverage {
	public static void main(String[] args) {
		Drinks[]arr=new Drinks[4];
		arr[0]=new Juice();
		arr[1]=new Coffee();
		arr[2]=new Beer();
		arr[3]=new Water();
		for(Drinks d:arr)
			d.drink();
	}

}
