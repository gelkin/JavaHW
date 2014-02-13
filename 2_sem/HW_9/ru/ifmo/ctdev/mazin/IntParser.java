package ru.ifmo.ctdev.mazin;

public class IntParser extends NumParser<Integer> {
	protected void apply(String s) {
		int i = 0;
        boolean negative = false;
     
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring(1);
        }
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        this.num = Integer.parseInt(s.substring(0, i));
        if( negative ) {
        	this.num = -this.num;
        }
        this.i = i;
	}
}
