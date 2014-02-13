public class Variables implements Evaluable{
	private String[] vars;
	
	public Variables(String var) {
		for (int i = 0; i < vars.length; i++) {
			if (vars[i].equals(var)) {
				
			}
		}
	}
	
	public int evaluate(int x) {
		return x;
	}
}
