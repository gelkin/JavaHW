package ru.ifmo.ctdev.mazin;

import java.util.Map;

public class Const implements Evaluable {
	private int value;
	
	public Const(int value) {
		this.value = value;
	}
	
	public int evaluate(Map<String, Integer> vars) throws NumException {
		return value;
	}
}
