public class ArrayQueue {
	private int size;
	private Object[] elements = new Object[10];
	private int tail;
	private int head;
	
	// Inv: size >= 0

	// pre: 
	// post: size' = size + 1 && elements[tail] = element 
	public void push(Object element) {
		assert element != null;
		
		ensureCapacity(size + 1);
		elements[tail] = element;
		tail = (tail + 1) % elements.length;
		size++;
	}
	
	// pre: capacity = size + 1
	// post: (elements.length < capacity)? 
	// 							elements.length' = 2*(elements.length + 1)
	// 							&& tail = elements.length && head = 0
	// 							: true
	private void ensureCapacity(int capacity) {
		if (capacity <= elements.length) {
			return;
		}
		Object[] newElements = new Object[2 * capacity];
		for (int i = 0; i < elements.length; i++) {
			if (i <= head) {
				newElements[elements.length - head + i] = elements[i];
			} else {
				newElements[i - head] = elements[i];
			}
		}
		tail = elements.length;
		head = 0;
		elements = newElements;
	}
	
	// pre: size > 0
	// post: size' = size - 1 && res = elements[head]
	public Object pop() {
		assert size > 0;
		
		Object value = elements[head];
		elements[head] = 0;
		head = (head + 1) % elements.length;
		return value;
	}
	
	// pre:
	// post: res = size
	public int size() {
		return size;
	}

	// pre:
	// post: res = (size == 0)	
	public boolean isEmpty() {
		return (size == 0);
	}
	
}
