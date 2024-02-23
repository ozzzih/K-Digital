package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test04 {
	public static void test() throws Exception {
			FileInputStream fi = new FileInputStream("a1.txt");
			int c = fi.read();
			System.out.println((char) c);

	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
