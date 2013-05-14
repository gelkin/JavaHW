package mazin;

import java.util.HashMap;
import mazin.*;

public class Parser {
    
    public Evaluable parse(String s) {
        Result result = plusMinus(s);
        return result.exp;
    }

    private Result plusMinus(String s) {
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
                exp = new Plus(exp, current.exp);
            } else {
                exp = new Minus(exp, current.exp);;
            }
        }
        return new Result(exp, current.rest);
    }
	
	private Result mulDiv(String s) {
        Result current = brackets(s);

        Evaluable exp = current.exp;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if (sign != '*' && sign != '/' && sign != '%') {
            	return current;
            }

            String next = current.rest.substring(1);
            Result right = brackets(next);

            if (sign == '*') {
                exp = new Times(exp, right.exp);
            } else if (sign == '/') {
                exp = new Division(exp, right.exp);
            } else {
            	exp = new ByModulo(exp, right.exp);
            }

            current = new Result(exp, right.rest);
        }
    }
	
    private Result brackets(String s) {
        char ch = s.charAt(0);
        if (ch == '(') {
            Result r = plusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Ошибка: не закрытая скобка");
            }
            return r;
        }
        return variable(s);
    }

    private Result variable(String s) {
        String f = "";
        int i = 0;
        
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            f += s.charAt(i);
            i++;
        }
        if (!f.isEmpty()) { 
        	return new Result((new Variable(f)), s.substring(f.length()));
        }
        return num(s);
    }

   private Result num(String s) {
        int i = 0;
        boolean negative = false;
     
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring(1);
        }
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        int dPart = Integer.parseInt(s.substring(0, i));
        if( negative ) {
        	dPart = -dPart;
        }
        String restPart = s.substring(i);

        return new Result((new Const(dPart)), restPart);
    }
} 
