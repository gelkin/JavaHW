public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		
		Object[] a = new Object[34];
		for (int i = 0; i < 34; i++) {
			queue.push(i);
		}
		for (int i = 0; i < 34; i++) {
			a[i] = queue.pop();
			System.out.println(a[i]);
		}
	}
}
