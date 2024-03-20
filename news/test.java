package news;


import java.util.ArrayList;
import java.util.List;

import com.ruby.java.ch06.ThisTest;
import com.ruby.java.recursive.Stack4.EmptyGenericStackException;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
* 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
* Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
* pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
* Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
* 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
*/
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
	}
}

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		top = 0;
		this.capacity = capacity;
		data = new ArrayList<Point>();
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if(isFull())
			throw new OverflowGenericStackException("push : stack overflow");
		data.add(x);
		top++;

		return true;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("pop : stack Empty");
		Point p = data.get(top -1);
		data.remove(top-1);
		top--;

		return p;
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("peek : stack Empty");
		return data.get(top-1);
	}

	// --- 스택을 비움 ---//
	public void clear() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("clear : stack Empty");
		else
			while(!isEmpty()) {
				data.remove(--top);
			}
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class test {
	public static void EightQueen(int[][] d)  {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		st.push(p);
		count++;
		ix++;
		
		
		while (!(iy == d[0].length && ix == 0)) {
			int newCol = nextMove(d, ix,iy);
			if(newCol != -1) {
				iy = newCol;
				d[ix][newCol] = 1; 
				st.push(new Point(ix,newCol)); // 새로 찾은 ix, 행탐색
				count ++;
				ix++; // 행탐색
				
				iy = 0; // y 초기화
				if(count == d.length) {
					numberSolutions++;
					System.out.println("#[" + numberSolutions + "]");
					showQueens(d);
//					Point np = null;
//					try {
//						np = st.pop();
//					} catch (news.Stack4.EmptyGenericStackException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					d[np.getX()][np.getY()] = 0;
//					ix = np.getX(); 
//					iy = np.getY();
//					count --; 
//					iy++; 
				}
				
			}else 
				{
				Point n = null;
				try {
					n = st.pop();
				} catch (news.Stack4.EmptyGenericStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 실행되고 리턴 // Point n 이라는 객체에 st에서 팝한걸 저장
				d[n.getX()][n.getY()] = 0;
				ix = n.getX(); //현 메소드 지역변수에 가지고 온 값을 넣는다.
				iy = n.getY();
				count --; // 카운트를 제거하고 다시 시작
				iy++; // 팝되고 나서 팝한 자리에서 열탐색
			}
	
		}
		//밑에 넥스트 무브의 메서드로 탐색을 하면서 넣는다. 행을 탐색하면서 넣는다. 
		//만약 행에 넣을 것이 없을 때 팝을 시키고 전 위치에서 부터 열 탐색 시작한다. 그래도 없다면 최종적으로 다 팝.
		//

	}
	public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		for(int i = 0; i < d.length; i++) {
			if(d[crow][i] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		for(int i = 0; i < d.length; i++) {
			if(d[i][ccol] == 1) {
				return false;
			}
		}
		return true;
	}

	//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		
		int x = cx;
		int y = cy;

		while((0 <= y &&  x < 8) ) {
			if(1 == d[x][y]) {
				return false;
			}
			x++;
			y--;
		}
		
		x= cx;
		y= cy;
		
		while((0 <= x && y < 8)) {
			
			if(1 == d[x][y]) {
				return false;
			}
			x--;
			y++;
		}
		return true;
	}

	//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		
		int x = cx;
		int y = cy;

		while((x < 8 &&  y < 8) ) {
			if(1 == d[x][y]) {
				return false;
			}
			x++;
			y++;
		}
		
		x= cx;
		y= cy;
		
		while((0 <= y && 0 <= x)) {
			if(1 == d[x][y]) {
				return false;
			}
			x--;
			y--;
		} 
		return true;
	}

	//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if(checkCol(d, y) && checkRow(d, x) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y)) {
			return true;
		}
		return false;
	}
	//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for(int nextCol = col ; nextCol < d[0].length; nextCol++) {
			if(checkMove(d, row, nextCol)) {
				return nextCol;
			}
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data.length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public static void main(String[] args){
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}