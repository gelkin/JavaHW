package ru.ifmo.ctdev.mazin;

import java.util.Map;
import java.math.*;

public class Parser<T> {
    
    public Evaluable<T> parse(String s) {
        Result<T> result = plusMinus(s);
        return result.exp;
    }

    private Result<T> plusMinus(String s) {
        Result<T> current = mulDiv(s);
        Evaluable<T> exp = current.exp;

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
        return new Result<T>(exp, current.rest);
    }
	
	private Result<T> mulDiv(String s) {
        Result<T> current = brackets(s);
        Evaluable<T> exp = current.exp;
        
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if (sign != '*' && sign != '/') {
            	return current;
            }

            String next = current.rest.substring(1);
            Result<T> right = brackets(next);

            if (sign == '*') {
            	exp = new BinOper(Operation.TIMES, exp, current.exp);
            } else if (sign == '/') {
                /*if (T instanceof Integer) {
       			 	exp = new BinOper<T>(OperInt.DIVIDE, exp, right.exp);
        		} else if (T instanceof Double) {
        			exp = new BinOper<T>(OperDouble.DIVIDE, exp, right.exp);
       			} else {
        			exp = new BinOper<T>(OperBigInt.DIVIDE, exp, right.exp);
        		}
        		*/
        		exp = new BinOper(Operation.DIVIDE, exp, current.exp);
            }

            current = new Result<T>(exp, right.rest);
        }
    }
	
    private Result<T> brackets(String s) {
        char ch = s.charAt(0);
        if (ch == '(') {
            Result<T> r = plusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Ошибка: не закрытая скобка");
            }
            return r;
        }
        return variable(s);
    }

    private Result<T> variable(String s) {
        String f = "";
        int i = 0;
        
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            f += s.charAt(i);
            i++;
        }
        if (!f.isEmpty()) { 
        	return new Result<T>((new Variable<T>(f)), s.substring(f.length()));
        }
        if (T instanceof Integer) {
        	return numInt(s);
        } else if (T instanceof Double) {
        	return numDouble(s);
        } else {
        	return numBigInt(s);
        }/*else - exception of setting type T*/
        
    }

	private Result<T> numInt(String s) {
        int i = 0;
        boolean negative = false;
     
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring(1);
        }
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        int part = Integer.parseInt(s.substring(0, i));
        if( negative ) {
        	part = -part;
        }
        String restPart = s.substring(i);

        return new Result<T>((new Const<T>(part)), restPart);
    }
    
	private Result<T> numDouble(String s) /* throws Exception */ {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            /*if (s.charAt(i) == '.' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
            }
            */
            i++;
        }
        /*if( i == 0 ){ // что-либо похожее на число мы не нашли
            throw new Exception( "can't get valid number in '" + s + "'" );
        }*/

        double part = Double.parseDouble(s.substring(0, i));
        if( negative ) { 
        	part = -part;
       	}
        String restPart = s.substring(i);

        return new Result<T>((new Const<T>(part)), restPart);
    }
    
    private Result<T> numBigInt(String s) {
        int i = 0;
        boolean negative = false;
     
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring(1);
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        BigInteger part = new BigInteger(s.substring(0, i));
        if( negative ) {
        	part = part.negate();
        }
        String restPart = s.substring(i);

        return new Result<T>((new Const<T>(part)), restPart);
    }
} 
