package ru.ifmo.ctdev.mazin;

public class Division extends AbstractBinOper {
	public Division(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) throws NumException {
		if (y == 0) {
    		throw new NumException("division by zero");
    	} else if (y == -1) {
    		throw new NumException("overflow");
    	} else {
    		return x / y;
    	}
	}
}
