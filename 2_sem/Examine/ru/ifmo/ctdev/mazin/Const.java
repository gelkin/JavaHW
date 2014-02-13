package ru.ifmo.ctdev.mazin;

import java.util.List;

public class Const implements Evaluable {
	private int value;
	
	public Const(int value) {
		this.value = value;
	}
	
	public int evaluate(List<Evaluable> elements, List<Integer> result) throws NumException {
		return value;
	}
}
