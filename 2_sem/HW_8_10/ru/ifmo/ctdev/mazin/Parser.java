package ru.ifmo.ctdev.mazin;

import java.math.*;

public class Parser {
    
    public Evaluable parse(String s) throws ExpException {
        Result result = plusMinus(s);
        return result.exp;
    }

    private Result plusMinus(String s) throws ExpException {
        Result current = mulDiv(s);
        Evaluable exp = current.exp;

        while (current.rest.length() > 0) {
 	     	char sign = current.rest.charAt(0);
            if (sign != '+' && sign != '-') {
            	break;
            }

            String next = current.rest.substring(1);
            current = mulDiv(next);
            
            if (sign == '+') {
                exp = new BinOper(Operation.PLUS, exp, current.exp);
            } else {
                exp = new BinOper(Operation.MINUS, exp, current.exp);
            }
        }
        return new Result(exp, current.rest);
    }
	
	private Result mulDiv(String s) throws ExpException {
        Result current = brackets(s);
        Evaluable exp = current.exp;
        
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if (sign != '*' && sign != '/') {
            	return current;
            }

            String next = current.rest.substring(1);
            Result right = brackets(next);

            if (sign == '*') {
            	exp = new BinOper(Operation.TIMES, exp, right.exp);
            } else {
        		exp = new BinOper(Operation.DIVIDE, exp, right.exp);
            }

            current = new Result(exp, right.rest);
        }
    }
	
    private Result brackets(String s) throws ExpException {
       	if ("".equals(s)) {
       		throw new ExpException("Incorrect expression");
       	}
        char ch = s.charAt(0);
        if (ch == '(') {
            Result r = plusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                throw new ExpException("Not closed bracket");
            }
            return r;
        }
        return variable(s);
    }

    private Result variable(String s) throws ExpException {
        String f = "";
        int i = 0;
        
        
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            f += s.charAt(i);
            i++;
        }
        if (!f.isEmpty()) { 
        	return new Result((new Variable(f)), s.substring(f.length()));
        }
        
        return numInt(s);
    }

	private Result numInt(String s) throws ExpException {
        int i = 0;
        boolean negative = false;
     
        if( s.charAt(0) == '-' ) {
            negative = true;
            s = s.substring(1);
        }
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        if (i == 0) {
        	throw new ExpException("Incorrect expression");
        }
        int part = Integer.parseInt(s.substring(0, i));
        if( negative ) {
        	part = -part;
        }
        String restPart = s.substring(i);
        return new Result((new Const(part)), restPart);
    }
	
} 
