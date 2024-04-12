package edu.pnu;

import java.util.Scanner;

public class QueryrByPreparedStatment4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String field, and, value;
		do {
			System.out.println("Code:");
			field = sc.next();
			and=sc.next();
			value=sc.next();
			
		}while(value!="!done");

	}

}
