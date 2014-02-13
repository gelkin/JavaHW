package ru.ifmo.ctdev.mazin;

public class Plus<T> extends AbstractBinOper<T> {
	public Plus(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected T apply(T x, T y) {
		return x + y; 
	}
}
