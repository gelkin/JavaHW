package mazin;

import java.util.HashMap;

public interface Evaluable {
	public abstract int evaluate(HashMap<String, Integer> vars);
	public abstract String toString(int priority);
	public abstract Evaluable simplify();
}
