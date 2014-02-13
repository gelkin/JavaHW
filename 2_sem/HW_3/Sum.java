public class Sum { 
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		double res = 0;
		int sumOfLenghts = 0;
		for (int i = 0; i < args.length; i++) {
			String[] arr = args[i].split(" +");
			if (arr[0].length() > 0) {
				sumOfLenghts += arr.length;
			} else {
				sumOfLenghts += arr.length - 1;
			}
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].length() > 0) {
					queue.push(Double.parseDouble(arr[j]));
				}
			}
		}
		for (int i = 0; i < sumOfLenghts; i++) {
			res += (Double) queue.pop();
		}
		
		System.out.println(res);
	}
}
