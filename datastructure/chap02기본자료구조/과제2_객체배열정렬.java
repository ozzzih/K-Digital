package chap02기본자료구조;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String string, int i, double d) {
		this.name=string;
		this.height=i;
		this.vision=d;
	}
	@Override
	public String toString() {
		return name+"의 키는 "+height+"cm이며, 시력은 "+vision+"이다.";
	}
	@Override
	public int compareTo(PhyscData p) {
		return this.name.compareTo(p.name);
	}
//	public int equals(PhyscData p) {
//		
//	}
}
public class 과제2_객체배열정렬 {
	static void swap(PhyscData[]arr, int ind1, int ind2) {
		PhyscData t = arr[ind1]; arr[ind1]=arr[ind2]; arr[ind2]=t;
	}
	static void sortData(PhyscData []arr) {
		System.out.println("<<<<<정렬시작>>>>>");
		for(int i = 0; i<arr.length; i++)
			for(int j=i+1; j<arr.length; j++)
				if(arr[i].compareTo(arr[j])>0)
					swap(arr, i, j);
	}
	public static void main(String[] args) {
		PhyscData[] data = {
			new PhyscData("홍길동", 162, 0.3),
			new PhyscData("홍동", 164, 1.3),
			new PhyscData("홍길", 152, 0.7),
			new PhyscData("김홍길동", 172, 0.3),
			new PhyscData("이길동", 182, 0.6),
			new PhyscData("박길동", 167, 0.2),
			new PhyscData("최길동", 169, 0.5)
		};
		showData(data);
		sortData(data);	
		//Arrays.sort(null, null);//comparator가 필요하다 
		showData(data);
	}
	static void showData(PhyscData[]arr) {
		for(PhyscData a: arr)
			System.out.println(a.toString());
	}

}