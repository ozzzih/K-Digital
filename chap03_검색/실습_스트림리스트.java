package chap03_검색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Comparator;
import java.util.Collections;
public class 실습_스트림리스트 {

	    public static String[] removeElement1(String[] arr, String item) {
	    	List<String> s_list = new ArrayList<>(Arrays.asList(arr));
	    	s_list.remove(item);
	    	return s_list.toArray(new String[0]);
	    }
	    
	    static void getList(List<String> list) {
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");

			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    static void showList(String topic, List<String> list) {
	    	System.out.println(topic + " :: ");
	    	for(String st:list) {
	    		System.out.println(st);
	    	}
	    }
	    
	    static void sortList(List<String> list) {
	    	//방법1:list.sort(null);
	    	Collections.sort(list);
	    	//방법2:리스트를 스트링 배열로 변환	    	
	    	//list.sort(Comparator.naturalOrder());
	    }
	    
	    static String[] removeDuplicateList(List<String> list) {
		    String cities[] = new String[0];
		    cities = list.toArray(cities);
		    //for문으로 도시가 중복인 것을 체크=compareTo를 사용해서
		    int count = cities.length;
		    for(int i=0; i<count; i++) {
		    	int j = i+1;
		    	while(j<count) {
		    		if(cities[i].compareTo(cities[j])==0) {
		    			cities=removeElement1(cities, cities[j]);
		    			count-=1;	
		    		}
		    		else j+=1;	
		    	}
		    }
//		    cities=Arrays.stream(cities).distinct().toArray(String[]::new);
		    return cities;
	    }
	    
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list);

//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}


