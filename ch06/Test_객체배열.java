
package com.ruby.java.ch06;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
* static 멤버 함수 구현
* toString() 함수 구현과 사용
* 객체 배열 사용
*/
abstract class InterfaceStudents {

	public abstract void showObject();
}
class Student extends InterfaceStudents {
	
	static int countStudents;//객체수
	int sid;//학번
	String sname; //학생 이름
	String city; //주소 도시
	public Student() {//default 생성자
		sid=0; sname=null; city=null;
		countStudents++;
	}
	public Student(int x) {
		this();
		this.sid=x;
	}
	public Student(int x, String name, String city) {
		this(x);
		this.sname=name;
		this.city=city;
	}
	public String toString() {
		 return "sid="+sid + ", sname=" + sname + ", city=" + city;
	}
	public void showObject() {
		 System.out.println("[" + sid + ", " + sname + ", " + city+"]");
	}
	static void showNumberObjects() {//생성된 객체수를 출력한다.
		 System.out.println(" 생성객체수=" + countStudents);
	}
}
class WorkStudent extends Student {
	String eno;
	String company;
	public WorkStudent() {
		eno=null;
		company=null;
	}
	public WorkStudent(int id, String sname, String city, String eno, String company) {
		super(id, sname, city);
		this.eno=eno;
		this.company=company;	
	}
	
	
	 public String toString() {
		 
		 return super.toString()+", eno="+eno+", company="+company;
	 }
	 public void showObject() {
		 //Student 출력 코드 추가
		 super.showObject();
		 System.out.println("["+eno +", " + company + "]"); 
	 }
}
class CodingWorkStudent extends WorkStudent {
	String language;
	public CodingWorkStudent() {
	}
	public CodingWorkStudent(String language) {
		this.language = language;
	}
	 public String toString() {
		 super.toString();
		 return super.toString()+", language="+language;
	 }
	 public void showObject() {
		 //WorkStudent 출력 코드 추가 
		 super.showObject();
		 System.out.println("["+language+"]");
		
	 }
}
// 생성자 구현한다.
public class Test_객체배열 {
	 static void showObjects(InterfaceStudents is) {
		 is.showObject();
	 }
	 public static void main(String[] args) {
	 Student arry[] = new Student[6];
	 Student.showNumberObjects();
	 arry[0] = new Student(); //디폴트생성자
	 arry[1] = new Student(202301);
	 arry[2] = new Student(202302, "Hong", "Busan");
	 arry[3] = new WorkStudent(202303,"Oh", "Seoul","e1","QWE company");
	 arry[4] = new CodingWorkStudent("English");
	 arry[5] = new WorkStudent(202304,"Kim", "Seoul","e2","WER company");
	 Student.showNumberObjects();
	 for (Student s : arry) {
		 System.out.println(s.toString()); //객체의 메서드 호출
	 }
	 for (Student sx : arry) {
		 showObjects(sx); //객체의 메서드가 아님, 일반함수임-인스턴스 생성하지않아도됨
	 }
}
	

}
