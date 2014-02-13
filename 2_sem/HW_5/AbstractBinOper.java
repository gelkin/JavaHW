public abstract class AbstractBinOper implements Evaluable {
	protected Evaluable left;
	protected Evaluable right;
	
	public AbstractBinOper(Evaluable left, Evaluable right) {
		this.left = left;
		this.right = right;
	}
	
	protected abstract int apply(int x, int y);
	
	public int evaluate(int[] arr) {
		return apply(this.left.evaluate(arr), this.right.evaluate(arr));
	}
}
