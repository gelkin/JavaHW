package ru.ifmo.ctdev.mazin;

import java.util.Map;
import ru.ifmo.ctdev.mazin.*;

public abstract class AbstractBinOper<T> implements Evaluable<T> {
	private Evaluable left;
	private Evaluable right;
	
	public AbstractBinOper(Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
	}
	
	protected abstract T apply(T x, T y);
	
	public T evaluate(Map<String, T> vars) {
		return apply(left.evaluate(vars), right.evaluate(vars));
	}
}
