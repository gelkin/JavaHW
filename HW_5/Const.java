public class Const implements Evaluable{
	private int value;
	
	public Const(int value) {
		this.value = value;
	}
	
	public int evaluate(int[] x) {
		return value;
	}
}
