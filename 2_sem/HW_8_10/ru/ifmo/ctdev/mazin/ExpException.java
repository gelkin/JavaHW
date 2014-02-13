package ru.ifmo.ctdev.mazin;

public class ExpException extends Exception {
	private String str;
	
	public ExpException(String str) {
		this.str = str;
	}
	
	public String get() {
		return str;
	}
}
