package ru.ifmo.ctdev.mazin;

public class Minus<T> extends AbstractBinOper<T> {
	public Minus(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected T apply(T x, T y) {
		return x - y; 
	}
}
