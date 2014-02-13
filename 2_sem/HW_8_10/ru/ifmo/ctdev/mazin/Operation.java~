package ru.ifmo.ctdev.mazin;

public enum Operation {
    PLUS { 
    	int apply(int x, int y) throws NumException { 
    		if( ((y >= 0) && (Integer.MAX_VALUE - y) < x) || 
    				( (y < 0) && (Integer.MIN_VALUE - y) > x) ) {
    			throw new NumException("overflow");
    		} else {
    			return x + y;
    		}
         } },
         
    MINUS  {
    	int apply(int x, int y) throws NumException {
    		if( ((y >= 0) && (Integer.MIN_VALUE + y) > x) || 
    				((y < 0) && (Integer.MAX_VALUE + y) < x) ){
    			throw new NumException("overflow");
    		} else {
    			return x - y;
    		}
         } },
         
    TIMES {
    	int apply(int x, int y) throws NumException { 
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
        } },
         
    DIVIDE {
    	int apply(int x, int y) throws NumException { 
    		if (y == 0) {
    			throw new NumException("division by zero");
    		} if (y == -1) {
    			throw new NumException("overflow");
    		} else {
    			return x / y;
    		}
    	} };
    
    abstract int apply(int x, int y) throws NumException;
}
