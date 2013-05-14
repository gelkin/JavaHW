public class ArrayQueueSingleton {
	private static int size;
	private static Object[] elements = new Object[10];
	private static int tail = elements.length - 1;
	private static int head = elements.length - 1;
	
	// Inv: size >= 0

	// pre: 
	// post: size' = size + 1 && elements[size] = element 
	public static void push(Object element) {
		assert element != null;
		
		ensureCapacity(size + 1);
      	elements[tail] = element;
      	tail = (tail - 1) % elements.length;
      	size++;
	}
	
	// pre: 
	// post: (size < capacity)? size' = 2*(size + 1) && tail = size + 1 && head = size' - 1 : true
	private static void ensureCapacity(int capacity) {
		if (capacity <= elements.length) {
			return;
		}
		Object[] newElements = new Object[2 * capacity];
		for (int i = 0; i < elements.length; i++) {
			if (i <= head) {
				newElements[2 * elements.length + 1 - (head - i)] = elements[i];
			} else {
				newElements[elements.length + 1 - (i - head)] = elements[i];
			}
		}
		tail = elements.length + 1;
		head = newElements.length - 1;
		elements = newElements;
	}
	
	// pre: size > 0
	// post: size' = size - 1 && (tail != head)?
	// 					res = elements[tail + 1] && elements[tail + 1] = 0 && tail' = tail + 1
	// 						: res = elements[0] && elements[0] = 0 && tail = 0
	public static Object pop() {
		assert size > 0;
		
		Object value = elements[head];
		elements[head] = 0;
		head = (head - 1) % elements.length;
		return value;
	}
	
	// pre:
	// post: res = size
	public static int size() {
      	return size;
	}

	// pre:
	// post: res = (size == 0)	
	public static boolean isEmpty() {
		return (size == 0);
	}
	
	public static int head(){
		return head;
	}
	
	public static int tail(){
		return tail;
	}
}
