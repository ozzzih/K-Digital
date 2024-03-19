package chap05_재귀알고리즘;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

import chap05_재귀알고리즘.Stack4.EmptyGenericStackException;

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
		private static final long serialVersionUID = 1L;

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
		try {
			data = new ArrayList<Point>() ; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (isFull()) // 스택이 가득 참
			throw new OverflowGenericStackException("push: stack overflow");
		data.add(x); top++;
		return true;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException("pop: stack empty");
		Point result = data.get(top-1); 
		data.remove(top-1); top--;
		return result;
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException("peek: stack empty");
		return data.get(top-1);
	}

	// --- 스택을 비움 ---//
	public void clear() throws EmptyGenericStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyGenericStackException("clear: stack empty");
		top=0;
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

public class 과제5_1_8Queen {
	public static void EightQueen(int[][] d) {
		int ix = 0; int iy = 0;
		int count = 0;
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		Stack4 st = new Stack4(100);
		st.push(p);
		count++;
		ix++;

		int rescount = 0;

		while (!(iy == d[0].length && ix == 0)) {
			int nm = nextMove(d, ix, iy);
			 
			if (nm != -1) {
				iy = nm;
				d[ix][iy] = 1;
				Point p1 = new Point(ix, iy);
				//System.out.println("st에 push"+p1);				
				st.push(p1);
				count++;
				ix++; iy = 0;
			}
			else {
				Point pp=null;
				
				try {
					pp = st.pop();		
					//System.out.println("st에서 pop" + pp);
				} catch (EmptyGenericStackException e) {
					e.printStackTrace();
				}
				ix = pp.getX();
				iy = pp.getY();
				d[ix][iy] = 0;
				iy++; count--;
			}
			if (count == d[0].length) {
				try {
					System.out.println("<<<"+(rescount+1)+"번째 해답"+">>>");
					st.dump();
					showQueens(d);
				} catch (EmptyGenericStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Point np = null;
				try {
					np = st.pop();
				} catch (EmptyGenericStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ix = np.getX();
				iy = np.getY();
				d[ix][iy] = 0;
				count--;
				iy++;
				rescount++;
			}		
		}
	}
		public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
			for (int i = 0; i < d[0].length; i++) {
				if (d[crow][i] == 1) {
					return false;
				}
			}
			return true;
		}
		
		public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
			for (int i=0; i<d.length; i++) {
				if(d[i][ccol]==1)
					return false;
			}
			return true;
		}
		
		//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
			int cxp = cx;
			int cxm = cx;

			int cyp = cy;
			int cym = cy;
			
			while ((cxp >= 0 && cxp < d.length) && (cyp >= 0 && cyp < d[0].length)) {
				if (d[cxp][cyp] == 1) {
					return false;
				}
				cxp++; cyp--;
			}

			while ((cxm >= 0 && cxm < d.length) && (cym >= 0 && cym < d[0].length)) {
				if (d[cxm][cym] == 1) {
					return false;
				}
				cxm--; cym++;
			}
			return true;
		}

		//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
			int cxp = cx;
			int cxm = cx;

			int cyp = cy;
			int cym = cy;

			while ((cxp >= 0 && cxp < d.length) && (cyp >= 0 && cyp < d[0].length)) {
				if (d[cxp][cyp] == 1) {
					return false;
				}
				cxp++; cyp++;
			}

			while ((cxm >= 0 && cxm < d.length) && (cym >= 0 && cym < d[0].length)) {
				if (d[cxm][cym] == 1) {
					return false;
				}
				cxm--; cym--;
			}
			return true;
		}
		//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
		public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
			if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d, x, y) && checkDiagSW(d, x, y))
				return true;
			return false;
		}
		
		//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
		public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
			for (int nextCol = col; nextCol < d[0].length; nextCol++) {
				if (checkMove(d, row, nextCol))
					return nextCol;
			}
			return -1;
		}
	
	static void showQueens(int[][] data) {// 배열 출력
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[0].length; j++)
				System.out.print(data[i][j]+"\t");
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;
				

		EightQueen(data);

	}
}