package ru.ifmo.ctdev.mazin;

import java.util.HashMap;
import ru.ifmo.ctdev.mazin.*;

public class Main {
	public static void main(String[] args) {
		
		HashMap<String, Integer> vars = new HashMap<String, Integer>();
		if (args.length > 1) {
			vars.put("x", Integer.parseInt(args[1]));
			vars.put("y", Integer.parseInt(args[2]));
			vars.put("z", Integer.parseInt(args[3]));
		}
		
		System.out.println((new Parser()).parse(args[0]).evaluate(vars));
	}
}
