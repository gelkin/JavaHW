package ru.ifmo.ctdev.mazin;

import java.util.HashMap;

public class Variable<T> implements Evaluable<T> {
	private String var;
	
	public Variable(String var) {
		this.var = var;
	}
	
	public T evaluate(HashMap<String, T> vars) {
        return vars.get(var);
	}
}
