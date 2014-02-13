package ru.ifmo.ctdev.mazin;

import java.util.HashMap;

public class BinOper implements Evaluable {
    private Operation op;
    
    private Evaluable left;
	private Evaluable right;
	
	public BinOper(Operation op, Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public int evaluate(HashMap<String, Integer> vars) {
		return op.apply(this.left.evaluate(vars), this.right.evaluate(vars));
	}
}
