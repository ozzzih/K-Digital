package com.ruby.java.ch08.innerClass;

class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {
		this.data = data; link = null;
	}
}


class LinkedList3 {
	Node3 first; 
	void append(int data) {
		Node3 p = first; Node3 q = null;
		Node3 newNode = new Node3(data); //Node(data)의 주소를 가리키는 중
		if(p == null) { //맨처음이냐
			first= newNode; //방금 생성된 노드를 첫번째로 지정
		}else {//이미 있다면
			q=p;
			while(q.link != null) {
				q = q.link;
			}//마지막 노드의 link에 도달
			q.link = newNode;
		}
		

			
	}
	void showList() {
		System.out.println();
		Node3 p = first; Node3 q=null;
		if(p == null) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			q = p;
			while(q!=null) {
				System.out.println(q.data);
				q=q.link;
			}
		}

	}
	void insert(int data) {
		Node3 newNode = new Node3(data);
		Node3 p = first; Node3 q = null;
        if (p.data >= newNode.data) {
            newNode.link = p;
            first = newNode;
            
        } else {
            q = p;
            while (q.link != null && q.link.data < newNode.data) {
                q = q.link;
            }
            newNode.link = q.link;  
            q.link = newNode;
        }
	}
}

public class Test_연결리스트와배열 {
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++;
		}
		return count;
	}
	static void showList(int[]data) {
		System.out.println();
		for (int i=0; i < data.length; i++)
			System.out.print(" " + i + " ");
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
		System.out.println();
	}
	static int insertList(int[] data, int count, int x) {
		int idx=0;
		while(x>=data[idx]) {
			idx++;
		}
		int arr[]=new int[count-idx+1]; //7-3+1
		for(int i=idx; i<count; i++) {
			
			arr[i-idx]=data[i];
		}
		data[idx]=x;
		for(int i=idx+1; i<count+1; i++) {
			
			data[i]=arr[i-idx-1];
		}
		
		count++;
		return count;
	}
	

	public static void main(String[] args) {
		int[]list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		count = insertList(list, count, 3);
		showList(list);
		count = insertList(list, count, 7);
		showList(list);
		
		LinkedList3 ll = new LinkedList3();
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25);
		ll.showList();
		ll.insert(3);ll.showList();
		ll.insert(7);ll.showList();
	}
}