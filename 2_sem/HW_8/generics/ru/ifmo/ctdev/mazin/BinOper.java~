package ru.ifmo.ctdev.mazin;

import java.util.Map;

public class BinOper<T> implements Evaluable<T> {
    private Operation<T> op;
    
    private Evaluable<T> left;
	private Evaluable<T> right;
	
	public BinOper(Operation<T> op, Evaluable<T> left, Evaluable<T> right) {
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public T evaluate(Map<String, T> vars) {
		return op.apply(left.evaluate(vars), right.evaluate(vars));
	}
}
