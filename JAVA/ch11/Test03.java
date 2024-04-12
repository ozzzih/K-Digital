package com.ruby.java.ch11;
import java.io.FileInputStream;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) {
		try(FileInputStream fi = new FileInputStream("a.txt")){
			int c; //a.txt 파일에서 한 글자를 읽어 정수로 변환
			while((c=fi.read())!=-1) {
				System.out.println((char) c); //위에서 처리한걸 char타입으로 변경
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
