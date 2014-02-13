package ru.ifmo.ctdev.mazin;

public class Times extends AbstractBinOper {
	public Times(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x * y; 
	}
}
