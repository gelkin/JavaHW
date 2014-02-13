package ru.ifmo.ctdev.mazin;

public class Division<T> extends AbstractBinOper<T> {
	public Division(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected T apply(T x, T y) {
		return x / y; 
	}
}
