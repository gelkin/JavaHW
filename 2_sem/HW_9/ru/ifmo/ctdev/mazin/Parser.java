package ru.ifmo.ctdev.mazin;

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
                exp = new Plus(exp, current.exp);
            } else {
                exp = new Minus(exp, current.exp);;
            }
        }
        return new Result(exp, current.rest);
    }
	
	private Result mulDiv(String s) {
        Result<T> current = brackets(s);
        Evaluable<T> exp = current.exp;
        
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if (sign != '*' && sign != '/' && sign != '%') {
            	return current;
            }

            String next = current.rest.substring(1);
            Result<T> right = brackets(next);

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
        	return new Result((new Variable(f)), s.substring(f.length()));
        }
        return num(s);
    }

   private Result num(String s) {
       NumParser<T> element = new NumParser();
       element.numParse(s);
       T num = element.getNum();
       int i = element.getIndex();

       return new Result((new Const(num)), s.substring(i));
    }
} 
