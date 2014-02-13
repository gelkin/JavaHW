package ru.ifmo.ctdev.mazin;

import java.util.Map;
import ru.ifmo.ctdev.mazin.*;

public class Main {
	public static void main(String[] args) {
		String str = args[0];
		if (args.length <= 2) {
			System.out.println("Мало аргументов!");
			return;
		}
		switch(str) {
			case "-i":
				HashMap<String, Integer> vars = new HashMap<String, Integer>();		
				vars.put("x", Integer.parseInt(args[2]));
				vars.put("y", Integer.parseInt(args[3]));
				vars.put("z", Integer.parseInt(args[4]));
				System.out.println((new Parser<Integer>()).parse(args[1]).evaluate(vars));
				break;
			case "-d":
				HashMap<String, Double> vars = new HashMap<String, Double>();		
				vars.put("x", Double.parseDouble(args[2]));
				vars.put("y", Double.parseDouble(args[3]));
				vars.put("z", Double.parseDouble(args[4]));
				System.out.println((new Parser<Double>()).parse(args[1]).evaluate(vars));
				break;
			case "-bi":
				HashMap<String, BigInteger> vars = new HashMap<String, BigInteger>();		
				vars.put("x", new BigInteger(args[2]));
				vars.put("y", new BigInteger(args[3]));
				vars.put("z", new BigInteger(args[4]));
				System.out.println((new Parser<BigInteger>()).parse(args[1]).evaluate(vars));
				break;
			default:
				System.out.println("Ошибка!");
				return;
		}
	}
}
