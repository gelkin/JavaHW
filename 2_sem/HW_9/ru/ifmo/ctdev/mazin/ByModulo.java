package ru.ifmo.ctdev.mazin;

public class ByModulo<T> extends AbstractBinOper<T> {
	public ByModulo(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected T apply(T x, T y) {
		return x % y; 
	}
}
