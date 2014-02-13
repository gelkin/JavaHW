package mazin;

import java.util.HashMap;
import mazin.*;

public class Main {
	public static void main(String[] args) {
		
		HashMap<String, Integer> vars = new HashMap<String, Integer>();
		if (args.length > 1) {
			vars.put("x", Integer.parseInt(args[1]));
			vars.put("y", Integer.parseInt(args[2]));
			vars.put("z", Integer.parseInt(args[3]));
		}
		
		Evaluable exp = ((new Parser()).parse(args[0]));
		System.out.println(exp.evaluate(vars));
		System.out.println(exp.toString());
	}
}
