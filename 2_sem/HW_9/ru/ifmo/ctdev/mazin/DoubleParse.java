package ru.ifmo.ctdev.mazin;

public class DoubleParser extends NumParser<Double> {
	
	public Pair<Double> numParse(String s) {
		int i = 0;
        boolean negative = false;
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            i++;
        }

        this.num = Double.parseDouble(s.substring(0, i));
        if( negative ) { 
        	this.num = -this.num;
       	}
		this.i = i;
	}
}
