package ru.ifmo.ctdev.mazin;

import java.util.Map;

public class Variable implements Evaluable {
	private String var;
	
	public Variable(String var) {
		this.var = var;
	}
	
	public int evaluate(Map<String, Integer> vars) throws NumException {
        return vars.get(var);
	}
}
