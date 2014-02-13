package ru.ifmo.ctdev.mazin;

public class Minus extends AbstractBinOper {
	public Minus(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) throws NumException {
		if( ((y >= 0) && (Integer.MIN_VALUE + y) > x) || 
    		((y < 0) && (Integer.MAX_VALUE + y) < x) ){
    		throw new NumException("overflow");
    	} else {
    		return x - y;
    	}
	}
}
