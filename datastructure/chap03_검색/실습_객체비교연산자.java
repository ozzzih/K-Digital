package chap03_검색;

import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData3 {
	String name;
	int height;
	double vision;
	public PhyscData3(String string, int i, double d) {
		this.name=string;
		this.height=i;
		this.vision=d;
	}
	@Override
	public String toString() {
		return name+"의 키는 "+height+"cm이며, 시력은 "+vision+"이다.";
	}
}

class HeightOrderComparator2 implements Comparator<PhyscData3>{
	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		// TODO Auto-generated method stub
		return (o1.height>o2.height)?1:
			(o1.height<o2.height)?-1:0;
	}	
}

public class 실습_객체비교연산자 {
	static final Comparator<PhyscData3> HEIGHT_ORDER = new HeightOrderComparator2();
	static void showData(String topic, PhyscData3[] arr) {
		System.out.println(topic+" :: ");
		for(PhyscData3 a:arr)
			System.out.println(a.toString());
	}
	
	public static void main(String[] args) {
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("홍동", 164, 1.3),
				new PhyscData3("홍길", 152, 0.7),
				new PhyscData3("김홍길동", 172, 0.3),
				new PhyscData3("길동", 182, 0.6),
				new PhyscData3("길동", 167, 0.2),
				new PhyscData3("길동", 167, 0.5),
		};
		System.out.println(data[3].height);
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);
		System.out.println();
		
		showData("정렬후 객체 배열", data);
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		System.out.println();
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nArrays.binarySearch(): result = " + idx);
	}
}