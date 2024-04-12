package chap06_정렬;
/*
 * 6장 구현과제1
 */

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  this.exp = exp; 
    }

    //--- 신체검사 데이터를 문자열로 반환 --//
    @Override
	public String toString() {
        return coef + "x**" + exp + " ";
    }
    @Override
    public int compareTo(Polynomial3 d2) { //지수가 같으면 계수로 비교
    	return d2.exp - exp;
    }
}
public class 과제6_2_Test_Merge정렬다항식 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial3 temp[] = new Polynomial3[50];
		//구현코드
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[p].compareTo(a[q])<0) temp[ix++] = a[p++];
			else if (a[p].compareTo(a[q])>0) temp[ix++] = a[q++];
			else {
				temp[ix++] = a[p++];temp[ix++] = a[q++];
			}
		}
		while (p > righta && q <= rightb) temp[ix++] = a[q++];
		while (q > rightb && p <= righta) temp[ix++] = a[p++];
		for (int j = 0; j < ix; j++) {
			a[lefta+ j] = temp[j];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		//str 변수는 다항식 이름으로 스트링이다
		//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
		//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		System.out.println(str);
		for(int i=0; i<n-1; i++) {
			System.out.print(String.format("%.1f", x[i].coef)+"x**"+x[i].exp+" + ");
		}
		System.out.println(String.format("%.1f", x[n-1].coef)+"x**"+x[n-1].exp);
		
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다 
		int p=0,q=0,r=0;
		int terms = 0; //항의 수
		//구현코드
		while(p<x.length&&q<y.length) {
			if(x[p].exp==y[q].exp) {
				z[r]=new Polynomial3(x[p].coef+y[q].coef, x[p].exp);
				p++; q++; r++; terms++;
			}else if(x[p].exp>y[q].exp) {
				z[r]=x[p];
				p++; r++; terms++;
			}else {
				z[r]=y[q];
				q++; r++; terms++;
			}
		}
		return terms;
		
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) { //곱셈 때 활용
		//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		//추가된 항의 수를 count하여 terms으로 리턴한다.
		//구현코드
		for(int i=0; i<terms; i++) {
			
			if(term.exp==z[i].exp) {
				z[i].coef=z[i].coef+term.coef;
				return terms;
			}
		}
		z[terms]=term;
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 
		//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int terms = 0;
		//구현코드
		for (int p=0; p<x.length; p++) {
			for(int q=0; q<y.length; q++) {
				Polynomial3 newTerm = new Polynomial3();
				newTerm.coef=x[p].coef*y[q].coef;
				newTerm.exp=x[p].exp+y[q].exp;
				terms = addTerm(z, newTerm, terms);			
			}
		}	
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		for(int i=0; i<zTerms; i++) {
			result+=z[i].coef*Math.pow(value, z[i].exp);
		}
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		Polynomial3[] z1 = new Polynomial3[50];
		for (int i =0; i < z1.length; i++)
			z1[i] = new Polynomial3();
		zTerms = MultiplyPolynomial(x,y,z1);//다항식 곱셈 z = x * y
		MergeSort(z1, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z1, zTerms);
		double result = EvaluatePolynomial(z1, zTerms, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + String.format("%.1f", result));
	}
}
