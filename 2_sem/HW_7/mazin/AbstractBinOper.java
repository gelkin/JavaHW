package mazin;

import java.util.HashMap;
import mazin.*;

public abstract class AbstractBinOper implements Evaluable {
	protected Evaluable left;
	protected Evaluable right;
	
	public AbstractBinOper(Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
	}
	
	public int evaluate(HashMap<String, Integer> vars) {
		return apply(this.left.evaluate(vars), this.right.evaluate(vars));
	}
	
	protected abstract int apply(int x, int y);
	
	public Evaluable simplify() {
		left = left.simplify();
		right = right.simplify();
		return simplifyHelper();
	}
	
	protected abstract Evaluable simplifyHelper();
}
