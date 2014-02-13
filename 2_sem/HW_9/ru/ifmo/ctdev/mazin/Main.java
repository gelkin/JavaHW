package ru.ifmo.ctdev.mazin;

import java.util.HashMap;
import java.math.*;
import ru.ifmo.ctdev.mazin.*;

public class Main {
	public static void main(String[] args) {
		String type = args[0];
		if ("-i".equals(type)) {
			Map<String, Integer> vars = new HashMap<String, Integer>();
			vars.put("x", Integer.parseInt(args[2]));
			System.out.println((new Parser()).parse(args[1]).evaluate(vars));
			
		} else if ("-d".equals(type)) {
			Map<String, Double> vars = new HashMap<String, Double>();
			vars.put("x", Double.parseDouble(args[2]));
			System.out.println((new Parser()).parse(args[1]).evaluate(vars));
			
		} else {
			Map<String, BigInteger> vars = new HashMap<String, BigInteger>();
			vars.put("x", new BigInteger(args[2]));
			System.out.println((new Parser()).parse(args[1]).evaluate(vars));
			
		}
	}
}
