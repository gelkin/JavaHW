package mazin;

import java.util.HashMap;

public class Variable implements Evaluable{
	private String var;
	
	public Variable(String var) {
		this.var = var;
	}
	
	public int evaluate(HashMap<String, Integer> vars) {
        return vars.get(var);
	}
	
	public String toString(int priority) {
		return var;
	}
	
	public Evaluable simplify() {
		return this;
	}
}
