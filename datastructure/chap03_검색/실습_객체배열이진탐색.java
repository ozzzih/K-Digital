package chap03_검색;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	public PhyscData2(String string, int i, double d) {
		this.name=string;
		this.height=i;
		this.vision=d;
	}
	@Override
	public String toString() {
		return name+"의 키는 "+height+"cm이며, 시력은 "+vision+"이다.";
	}
	@Override
	public int compareTo(PhyscData2 p) {
//		if(vision > p.vision)
//			return 1;
//		else if (vision < p.vision)
//			return -1;
//		else if(height>p.height)
//			return 1;
		return this.name.compareTo(p.name);
	}
//	public int equals(PhyscData2 p) {
//		
//	}
}
public class 실습_객체배열이진탐색 {
	static void swap(PhyscData2[]arr, int ind1, int ind2) {
		PhyscData2 t = arr[ind1]; arr[ind1]=arr[ind2]; arr[ind2]=t;
	}
	static void sortData(PhyscData2[] arr) {
		System.out.println();
		System.out.println("<<<<<데이터를 오름차순으로 정렬합니다.>>>>>");
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i].compareTo(arr[j])>0) {
					swap(arr, i, j);
				}
			}
		}
	}
	static void reverse(PhyscData2[] a) {//교재 67페이지
		System.out.println();
		System.out.println("<<<<<데이터를 역순으로 정렬합니다.>>>>>");
		for (int i=0; i<a.length/2; i++)
			swap(a, i, a.length-i-1);
	}
	
	static void showData(String topic, PhyscData2[] arr) {
		System.out.println(topic+" :: ");
		for(PhyscData2 a:arr)
			System.out.println(a.toString());

	}
	
	static int linearSearch(PhyscData2[]item, PhyscData2 key) {
		int i=0;
		int n=item.length-1;
		while(true) {
			if(i==n)
				return -1;
			if(item[i].compareTo(key)==0)
				return 1;
			i++;
		}
	}
	static int binarySearch(PhyscData2[]item, PhyscData2 key) {
		int pl = 0;
		int pr = item.length-1;
		
		do {
			int pc = (pl+pr)/2;
			if (item[pc]==key)
				return pc;
			else if(item[pc].compareTo(key)<0)
				pl = pc+1;
			else
				pr = pc-1;
		}while(pl<=pr);
		
		return -1; //검색 실패
	}

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("이동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		if(data[0].compareTo(data[1])>0)
			System.out.println();
		
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는?
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nlinearSearch(<길동,167,02>): result = " + resultIndex);
		
		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable를 사용
		if(resultIndex == -1)
			System.out.println("binarySearch결과, 그 값의 요소가 없습니다.");
		else
			System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		
		
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
	}
	
	

}
