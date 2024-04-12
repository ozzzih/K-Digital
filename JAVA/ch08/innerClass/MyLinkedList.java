package com.ruby.java.ch08.innerClass;

public class MyLinkedList {
	private Node head = null;
	private class Node{
		private String data;
		private Node link;
		
		public Node(String data) {//Node에 대한 생성자
			this.data=data;
		}
	}
	public void add(String data) {
		Node newNode = new Node(data); //Node(data)의 주소를 가리키는 중
		if(head == null) { //맨처음이냐
			head = newNode; //방금 생성된 노드를 첫번째로 지정
		}else {//이미 있다면
			Node next=head;
			while(next.link != null) {
				next = next.link;
			}//마지막 노드의 link에 도달
			next.link = newNode;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while(next!=null) {
				System.out.println(next.data);
				next=next.link;
			}
		}
	}

}
