package mazin;

import java.util.HashMap;

public class Const implements Evaluable{
	private int value;
	
	public Const(int value) {
		this.value = value;
	}
	
	public int evaluate(HashMap<String, Integer> vars) {
		return value;
	}
	
	public String toString(int priority) {
		return String.valueOf(value);
	}
	
	public Evaluable simplify() {
		return this;
	}
}
