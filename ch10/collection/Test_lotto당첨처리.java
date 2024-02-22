package com.ruby.java.ch10.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


//구현과제로 실습
//hashset을 arraylist로 변환하여 정렬하기 구현

/*
* 로또 당첨 규칙:
* 꽝: 번호 2개, 1개
* 5등: 번호 3개 - 5000원
* 4등: 번호 4개 - 5만원
* 3등: 번호 5개 - 150만원 - 판매금액에 변동(판매금액의 12.5%)
* 2등: 3등번호 + 보너스번호 - 3000만원 - 판매 금액에 변동, 당첨 확률: 1,300,000분의1
* 1등: 6개 숫자 - 당첨 확률 8,000,000 분의 1, 10억 ~ 30억
*/

public class Test_lotto당첨처리 {

	public static void main(String[] args) {

		lotto_generator(100);

	}

	//보너스 번호는 중복되어도 됨.
	public static void lotto_generator(int n) {
		Random number = new Random();
		List<HashSet<Integer>> lotSet = new ArrayList<>();
		HashSet<Integer> lotto = null;
		lotSet = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < n; i++) { //n줄의 복권번호(hashset)를 생성
			
			
			lotto = new HashSet<Integer>();
			for(int j = 0; lotto.size() <6 ; j++) {//복권 한줄 번호 랜덤 추출
				lotto.add(number.nextInt(45)+1);
			}
			lotSet.add(lotto);
		}
		System.out.println("\n<lotset hashset을 출력>\n");
		
		for (HashSet<Integer> eachLotto : lotSet) {
			List<Integer> L = new ArrayList<Integer>(eachLotto);
			Collections.sort(L);
			System.out.println(L);
	
		}
		
		//당첨번호 추첨
		HashSet<Integer> win = new HashSet<>();
		for (int j = 0; win.size()<6; j++) {
			win.add(1+number.nextInt(45));
		}
		//보너스 번호 추첨
		int bonus = 1+number.nextInt(45);
		System.out.print("당첨번호: " + win + " + 보너스 번호: "+bonus);//6개의 당첨번호와 보너스번호
		// 6개를 맞힌 복권을 찾는다 
		System.out.println();
		winnerLotto(win, bonus, lotSet);//1등을 찾는다
		
	}
	static void winnerLotto(HashSet<Integer> w, int bn, List<HashSet<Integer>> lot) {
		for (int i = 0; i < lot.size(); i++) {
			checkWinner(w, bn, lot.get(i));
		}
	}
	static void checkWinner(HashSet<Integer> w, int bn, HashSet<Integer> elem) {
		List<Integer> L = new ArrayList<>(w);
		int count = 0; //몇개 맞췄나
		for (int i = 0; i < L.size()-1; i++)
		{
			if(elem.contains(L.get(i)))
				count++;

		}
		switch (count) {
		case 0:
		case 1:
		case 2:
			System.out.println("꽝");
			break;
		case 3:
			System.out.println("5등 복권 " + elem + " 당첨번호:" + w);
			break;
		case 4:
			System.out.println("4등 복권 " + elem + " 당첨번호:" + w);
			break;
		case 5:
			if (elem.contains(bn)) { //보너스 번호가 일치하는 지를 조사 
				System.out.println("2등 복권 " + elem + " 당첨번호:" + w);
				break;
			}
			else {
				System.out.println("3등 복권 " + elem + " 당첨번호:" + w);
				break;
			}
			
		case 6:
			System.out.println("1등 복권 " + elem + " 당첨번호:" + w);
			break;
		}


	}
}