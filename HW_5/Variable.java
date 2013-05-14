public class Variable implements Evaluable{
	private String var;
	
	public Variable(String var) {
		this.var = var;
	}
	
	public int evaluate(int[] arr) {
		if ("x".equals(var)) {
			return arr[0];
		}
		if ("y".equals(var)) {
			return arr[1];
		}
		return arr[2];
	}
}
// TODO map (передавать в качестве аргумента)
