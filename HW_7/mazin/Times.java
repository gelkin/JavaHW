package mazin;

public class Times extends AbstractBinOper {
	public Times(Evaluable left, Evaluable right) {
		super(left, right);
	}
	
	protected int apply(int x, int y) {
		return x * y; 
	}
	
	public String toString(int priority) {
		String ans = left.toString(2) + "*" + right.toString(2);
		if (priority > 2) {
			ans = "(" + ans + ")";
		}
		return ans;
	}
	
	public Evaluable simplifyHelper() {
		if (left instanceof Const && right instanceof Const) {
			return new Const(Integer.parseInt(left.toString(0)) * Integer.parseInt(right.toString(0)));
		}
		if ("0".equals(left.toString(0)) || "0".equals(right.toString(0))) {
			return new Const(0);
		}
		if ("1".equals(left.toString(0))) {
			return right;
		}
		if ("1".equals(right.toString(0))) {
			return left;
		}
		return this;
	}
}
