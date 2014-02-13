public class ArrayQueueADT {
	private static int size;
	private static Object[] elements = new Object[10];
	private static int tail = 0;
	private static int head = 0;
	
	// Inv: size >= 0

	// pre: 
	// post: size' = size + 1 && elements[size] = element 
	public static void push(ArrayQueueADT queue, Object element) {
		assert element != null;
		
		ensureCapacity(queue, queue.size + 1);
      	queue.elements[queue.tail] = element;
      	queue.tail = (queue.tail + 1) % queue.elements.length;
      	queue.size++;
	}
	
	// pre: 
	// post: (size < capacity)? size' = 2*(size + 1) && tail = size + 1 && head = size' - 1 : true
	private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
		if (capacity <= queue.elements.length) {
			return;
		}
		Object[] newElements = new Object[2 * capacity];
		for (int i = 0; i < queue.elements.length; i++) {
			if (i <= queue.head) {
				newElements[queue.elements.length - queue.head + i)] = queue.elements[i];
			} else {
				newElements[i - queue.head] = queue.elements[i];
			}
		}
		queue.tail = queue.elements.length;
		queue.head = 0;
		queue.elements = newElements;
	}
	
	// pre: size > 0
	// post: size' = size - 1 && (tail != head)?
	// 					res = elements[tail + 1] && elements[tail + 1] = 0 && tail' = tail + 1
	// 						: res = elements[0] && elements[0] = 0 && tail = 0
	public static Object pop(ArrayQueueADT queue) {
		assert queue.size > 0;
		
		Object value = queue.elements[queue.head];
		queue.elements[queue.head] = 0;
		queue.head = (queue.head + 1) % queue.elements.length;
		return value;
	}
	
	// pre:
	// post: res = size
	public static int size(ArrayQueueADT queue) {
      	return queue.size;
	}

	// pre:
	// post: res = (size == 0)	
	public static boolean isEmpty(ArrayQueueADT queue) {
		return (queue.size == 0);
	}
	
}
