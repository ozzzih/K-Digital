package chap06_정렬;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		this.heap=new int[sz];
		this.n=0; this.MaxSize=sz;
	}

	public void display() {
		for(int i: heap) {
//			if(i==0) break;
			System.out.println(i+"\t");
		}
	}
	@Override
	public void Insert(int x) {
		int i;
		if (n == MaxSize) { HeapFull(); return; }
		n++; 
		for (i = n; i>=1; i/=2) {
			System.out.println(i);
			if (i == 1) break; // at root
			if (x <= heap[i / 2]) break;
			// move from parent to i
			heap[i] = heap[i / 2];
		}
		heap[i] = x;
	}
	@Override
	public int DeleteMax() {
		int i=1; 
		if(n==0) {HeapEmpty(); return 0;}
		int x = heap[1]; int k = heap[n--];
		for(int j=2; j<=n; j++) {
			if(j<n) {
				if(heap[j]<heap[j+1])
					j++;
			}
			if(k>heap[j]) break;
			heap[i]=heap[j];
			i=j; j*=2;
		}
		heap[i]=k;
		return x;
	}
//	Element<Type>* MaxHeap<Type>::DeleteMax(Element<Type>& x)
//	{
//		int i, j;
//		if (!n) { HeapEmpty(); return 0; }
//		x = heap[1]; Element<Type> k = heap[n]; n--;
//
//		for (i = 1, j = 2; j <= n; )
//		{
//			if (j < n) if (heap[j].key < heap[j + 1].key) j++;
//			// j points to the larger child
//			if (k.key >= heap[j].key) break;
//			heap[i] = heap[j];
//			i = j; j *= 2;
//		}
//		heap[i] = k;
//		return &x;
//	}


	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class 과제6_3_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];
	    

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				for(int i=0; i<count;i++) {
					int n = rnd.nextInt(100) + 1;
					x[i]=n;
					for(int j=0; j<i; j++){
						if(n == x[j]){
							i--;
						}
					}
				}
			
				for(int j=0; j<count; j++) {
					heap.Insert(x[j]);
				}
				break;
				
			case 2:
				heap.display();
				break;
				
			case 3:
				

				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
