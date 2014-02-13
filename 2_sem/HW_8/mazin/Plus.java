package ru.ifmo.ctdev.mazin;

public class Plus extends AbstractBinOper {
	public Plus(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x + y; 
	}
}
