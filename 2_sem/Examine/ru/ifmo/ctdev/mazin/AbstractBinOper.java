package ru.ifmo.ctdev.mazin;

import java.util.List;

public abstract class AbstractBinOper implements Evaluable {
	private Evaluable left;
	private Evaluable right;
	
	public AbstractBinOper(Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
	}
	
	protected abstract int apply(int x, int y) throws NumException;
	
	public int evaluate(List<Evaluable> elements, List<Integer> result) throws NumException {
		return apply(this.left.evaluate(elements, result), this.right.evaluate(elements, result));
	}
}
