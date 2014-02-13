package ru.ifmo.ctddef.mazin;

import java.util.HashMap;
import ru.ifmo.ctddef.mazin.*;

public abstract class AbstractBinOper implements Evaluable {
	private Evaluable left;
	private Evaluable right;
	
	public AbstractBinOper(Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
	}
	
	protected abstract int apply(int x, int y);
	
	public int evaluate(HashMap<String, Integer> vars) {
		return apply(this.left.evaluate(vars), this.right.evaluate(vars));
	}
}
