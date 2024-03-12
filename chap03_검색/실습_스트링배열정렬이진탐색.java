package chap03_검색;

//comparator 구현 실습
/*
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class 실습_스트링배열정렬이진탐색 {

	static void swap(String[]data, int ind1, int ind2) {
		String temp = data[ind1]; data[ind1] = data[ind2]; data[ind2] = temp;
	}
	
	static void reverse(String[] a) {//교재 67페이지
		for (int i=0; i<a.length/2; i++)
			swap(a, i, a.length-i-1);
	}
	
	static void showData(String topic, String[] data) {
		System.out.println(topic + " :: ");
		for(String d:data)
			System.out.print(d);
		System.out.println();
	}

	private static void sortData(String[] data) {
		System.out.println("데이터를 오름차순으로 정렬합니다.");
		for (int i=0; i<data.length; i++)
			for(int j=i+1; j<data.length; j++) {
				if(data[i].compareTo(data[j])>0)
					swap(data, i, j);
			}
	}
	static int linearSearch(String[]item, String key) {
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
	static int binarySearch(String[]item, String key) {
		int pl = 0;
		int pr = item.length-1;
		
		do {
			int pc = (pl+pr)/2;
			if (item[pc].compareTo(key)==0)
				return pc;
			else if(item[pc].compareTo(key)>0)
				pl = pc+1;
			else
				pr = pc-1;
		}while(pl<=pr);
		
		return -1; //검색 실패
	}
	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};//홍봉희 재배 과수

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);//역순으로 재배치
		showData("역순 재배치후", data);
		Arrays.sort(data);//Arrays.sort(Object[] a);
		showData("Arrays.sort()로 정렬후",data);
    
		String key = "포도";
		int resultIndex = linearSearch(data, key);
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nlinearSearch(포도): result = " + resultIndex);

		key = "배";
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nbinarySearch(배): result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): result = " + resultIndex);

	}



}
