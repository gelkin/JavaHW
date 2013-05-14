public class ArrayQueueSingletonTest {
	public static void main(String[] args) {
		Object[] a = new Object[21];
		for (int i = 0; i < 21; i++) {
			ArrayQueueSingleton.push(i);
		}
		for (int i = 0; i < 21; i++) {
			a[i] = ArrayQueueSingleton.pop();
			System.out.println(a[i]);
		}
	}
}
