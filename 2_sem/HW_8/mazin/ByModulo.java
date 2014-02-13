package ru.ifmo.ctdev.mazin;

public class ByModulo extends AbstractBinOper {
	public ByModulo(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x % y; 
	}
}
