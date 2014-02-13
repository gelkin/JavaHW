public class Main {
	public static void main(String[] args) {
		Division x = new Division(new Plus(new Times(new Variable("x"), new Variable("y")),
													 new Const(3)), new Variable("z"));
		int[] arr = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		System.out.println(x.evaluate(arr));
	}
}
