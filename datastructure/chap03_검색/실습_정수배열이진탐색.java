package chap03_검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
/*
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class 실습_정수배열이진탐색 {
	static void inputData(int[] data) {
		Random rand = new Random();
		for(int i=0; i<data.length; i++) {
			data[i]=rand.nextInt(50)+1;
		}
	}
	
	static void showList(String topic, int[] data) {
		System.out.println(topic+" :: ");
		for(int d:data)
			System.out.print(d+"\t");
		System.out.println();
	}
	
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int t = arr[ind1]; arr[ind1]=arr[ind2]; arr[ind2]=t;
	}
	
	static void sortData(int[] data) {
		System.out.println("데이터를 오름차순으로 정렬합니다.");
		for (int i=0; i<data.length; i++)
			for(int j=i+1; j<data.length; j++) {
				if(data[i]>data[j])
					swap(data, i, j);
			}
	}
	
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);// 구현 반복 숙달 훈련

		showList("정렬 전 배열[]:: ", data);
		sortData(data);// 구현 반복 숙달 훈련
		//Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = 13;
		int resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없다
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nlinearSearch(13): result = " + resultIndex);

		key = 19;
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nbinarySearch(19): result = " + resultIndex);
		
		key = 10;
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		if(resultIndex == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}
	
	static int linearSearch(int[]item, int key) {
		int i=0;
		int n=item.length-1;
		while(true) {
			if(i==n)
				return -1;
			if(item[i]==key)
				return 1;
			i++;
		}
	}

	static int binarySearch(int[]item, int key) {
		int pl = 0;
		int pr = item.length-1;
		
		do {
			int pc = (pl+pr)/2;
			if (item[pc]==key)
				return pc;
			else if(item[pc]<key)
				pl = pc+1;
			else
				pr = pc-1;
		}while(pl<=pr);
		
		return -1; //검색 실패
	}
}
