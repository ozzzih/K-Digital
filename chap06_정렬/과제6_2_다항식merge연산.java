package chap06_정렬;

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수
	public Polynomial(double d, int i) {
		coef=d;
		exp=i;
	}
	@Override
	public int compareTo(Polynomial o) {
		return (this.exp<o.exp)?1:
			(this.exp>o.exp)?-1:0;
	}


}
public class 과제6_2_다항식merge연산 {

	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {
		Polynomial temp[] = new Polynomial[30];
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[p].compareTo(a[q])<0) temp[ix++] = a[p++];
			else if (a[p].compareTo(a[q])>0) temp[ix++] = a[q++];
			else {
				temp[ix++] = new Polynomial(a[p++].coef+a[q++].coef, a[p++].exp);
			}
		}
		while (p > righta && q <= rightb) temp[ix++] = a[q++];
		while (q > rightb && p <= righta) temp[ix++] = a[p++];
		for (int j = 0; j < ix; j++) {
			a[lefta+ j] = temp[j];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	
	static void AddPolynomial(Polynomial[] a, Polynomial[] b, Polynomial[] c) {
		int n=0;
		for(int i=0; i<a.length; i++) {
			c[n++]=a[i];
		}
		for(int j=0; j<b.length; j++) {
			c[n++]=b[j];
		}
		MergeSort(c, 0, c.length - 1);
	}
	
	static void ShowPolynomial(Polynomial[] x) {
		for(int i=0; i<x.length-1; i++) {
			System.out.print(x[i].coef+"^"+x[i].exp+"+");
		}
		System.out.println(x[x.length-1].coef+"^"+x[x.length-1].exp);
	}

	public static void main(String[] args) {
		Polynomial[] x = {
		         new Polynomial(1.5, 3),
		         new Polynomial(2.5, 7),
		         new Polynomial(3.3, 2),
		         new Polynomial(4.0, 1),
		         new Polynomial(2.2, 0),
		         new Polynomial(3.1, 4),
		         new Polynomial(3.8, 5),
		     };
		Polynomial[] y = {
		         new Polynomial(1.5, 1),
		         new Polynomial(2.5, 2),
		         new Polynomial(3.3, 3),
		         new Polynomial(4.0, 0),
		         new Polynomial(2.2, 4),
		         new Polynomial(3.1, 5),
		         new Polynomial(3.8, 6),
		     };
		int nx = x.length;

		System.out.println("----정렬전----");
		ShowPolynomial(x);
		ShowPolynomial(y);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		System.out.println("----정렬후----");
		ShowPolynomial(x);
		ShowPolynomial(y);
		Polynomial[] z = new Polynomial[20];
		AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial(z);
		
	}
}
