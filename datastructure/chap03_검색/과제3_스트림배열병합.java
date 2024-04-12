package chap03_검색;
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;
public class 과제3_스트림배열병합 {
    static void showList(String topic, String [] list) {
    	System.out.println(topic + " :: ");
    	for(String l : list)
    		System.out.print(l + "\t");
    	System.out.println();
    }
    
    static String[] mergeList(String[]s1, String[] s2) {
    	int i = 0, j = 0;
    	String[] s3 = new String[10];
    	for(int k=0; k<s3.length; k++) {
    		if((i<s1.length)&(j<s2.length)) {
        		if(s1[i].compareTo(s2[j])<0) {
            		s3[k]=s1[i];
            		i+=1;
            	}else if(s1[i].compareTo(s2[j])>0){
            		s3[k]=s2[j];
            		j+=1;
            	}
        	}else if(i==s1.length) {
        		s3[k]=s2[j];
        		j+=1;
        	}else if(j==s2.length) {
        		s3[k]=s1[i];
        		i+=1;
        	}
    	}
    	return s3;
    }
    public static void main(String[] args) {
	String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
	Arrays.sort(s1); //comparable, comparator도 없다>comparable의 compareTo를 사용
	Arrays.sort(s2);
	//후속 코딩은 객체들의 정렬: Studendts 클래스를 만들ㅇ고 정렬
	showList("s1배열 = ", s1);
	showList("s2배열 = ", s2);
	//먼저 각 배열을 정렬한 후
	//p랑 q로 차례대로 비교해서 머지
	String[] s3 = mergeList(s1,s2);
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
}
}