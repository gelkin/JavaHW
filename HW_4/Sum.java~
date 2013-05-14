public class Sum {
	public static void main(String[] args) {
		ArrayQueue queue1 = new ArrayQueue();
		LinkedQueue queue2 = new LinkedQueue();
		queueSum(args, queue1);
		queueSum(args,queue2);
	}
	
	public static void queueSum(String[] args, Queue queue) {
		double res = 0;
		for (int i = 0; i < args.length; i++) {
			String[] arr = args[i].split(" +");
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].length() > 0) {
						queue.push(Double.parseDouble(arr[j]));
					}
				}
		}
		
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			res += (Double) queue.pop();
		}
		System.out.println(res);
	}
}
