package com.ruby.java.ch11;

public class NagativeNumberException extends Exception{
	public NagativeNumberException() {
		super("음수는 허용되지 않습니다.");
	}
	public NagativeNumberException(String message) {
		super(message);
	}
}
