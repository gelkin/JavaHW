package ru.ifmo.ctdev.mazin;

public class Times<T> extends AbstractBinOper<T> {
	public Times(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected T apply(T x, T y) {
		return x * y; 
	}
}
