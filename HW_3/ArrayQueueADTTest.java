public class ArrayQueueADTTest {
	public static void main(String[] args) {
		ArrayQueueADT queue = new ArrayQueueADT();
		
		Object[] a = new Object[34];
		for (int i = 0; i < 34; i++) {
			ArrayQueueADT.push(queue, i);
		}
		for (int i = 0; i < 34; i++) {
			a[i] = ArrayQueueADT.pop(queue);
			System.out.println(a[i]);
		}
	}
}
