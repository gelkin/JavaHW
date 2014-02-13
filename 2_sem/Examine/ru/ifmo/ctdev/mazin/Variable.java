package ru.ifmo.ctdev.mazin;

import java.util.List;

public class Variable implements Evaluable{
	private String var;
	
	public Variable(String var) {
		this.var = var;
	}
	
	public int evaluate(List<Evaluable> elements, List<Integer> result) throws NumException {
		int x = (-1) + Integer.parseInt(var.substring(1));
		if (x < 0 || x >= result.size()) {
			throw new NumException("Invalid link");
		}
		return result.get(x);
	}
}
