package ru.ifmo.ctdev.mazin;

public class Division extends AbstractBinOper {
	public Division(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x / y; 
	}
}
