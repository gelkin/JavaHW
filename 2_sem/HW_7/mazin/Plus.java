package mazin;

public class Plus extends AbstractBinOper {
	public Plus(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x + y; 
	}
	
	public String toString(int priority) {
		String ans = left.toString(0) + "+" + right.toString(0);
		if (priority > 0) {
			ans = "(" + ans + ")";
		}
		return ans;
	}
	
	public Evaluable simplifyHelper() {
		if (left instanceof Const && right instanceof Const) {
			return new Const(Integer.parseInt(left.toString(0)) + Integer.parseInt(right.toString(0)));
		}
		if ("0".equals(left.toString(0))) {
			return right;
		}
		if ("0".equals(right.toString(0))) {
			return left;
		}
		return this;
	}
}
