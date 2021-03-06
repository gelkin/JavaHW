package ru.ifmo.ctdev.mazin;

public class Times extends AbstractBinOper {
	public Times(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) throws NumException {
		if (y == 0) {
    		return 0;
    	}
    	if(( (x >= 0) && (y > 0) && ((Integer.MAX_VALUE / y) < x) ) ||
    		( (x >= 0) && (y < 0) && ((Integer.MIN_VALUE / y) < x) ) ||
    		( (x < 0) && (y > 0) && ((Integer.MIN_VALUE / y) > x) ) ||
    		( (x < 0) && (y < 0) && ((Integer.MAX_VALUE / y) > x) )) {
    		throw new NumException("overflow");
    	} else {
    		return x * y;
    	}
	}
}
