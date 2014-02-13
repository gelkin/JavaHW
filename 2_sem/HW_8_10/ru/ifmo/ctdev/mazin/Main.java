package ru.ifmo.ctdev.mazin;

import java.util.Map;
import java.util.HashMap;
import ru.ifmo.ctdev.mazin.*;

public class Main {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Мало аргументов!");
			return;
		}
		
		Map<String, Integer> vars = new HashMap<String, Integer>();		
		String str = args[0];
		
		try { 
			Evaluable exp = new Parser().parse(str);
		
			System.out.println("x   f");
			for (int i = 0; i < 10; i++) {
				try {
					vars.put("x", i);	
					System.out.println(i + " | " + exp.evaluate(vars));
				} catch (NumException e) {
					System.out.println(i + " | " + e.get());
				}
			}
		} catch (ExpException e) {
			System.out.println(e.get());
		}
	}
}
