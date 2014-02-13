package ru.ifmo.ctdev.mazin;

import java.util.Map;

public class BinOper implements Evaluable {
    private Operation op;
    
    private Evaluable left;
	private Evaluable right;
	
	public BinOper(Operation op, Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public int evaluate(Map<String, Integer> vars) throws NumException {
		return op.apply(left.evaluate(vars), right.evaluate(vars));
	}
}
