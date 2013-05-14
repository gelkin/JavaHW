public class ArrayQueue implements Queue {
	private int size;
	private Object[] elements = new Object[10];
	private int tail;
	private int head;
	
	public void push(Object element) {
		assert element != null;
		
		ensureCapacity(size + 1);
		elements[tail] = element;
		tail = (tail + 1) % elements.length;
		size++;
	}
	
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
	
	public Object pop() {
		assert size > 0;
		
		Object value = elements[head];
		elements[head] = 0;
		head = (head + 1) % elements.length;
		size--;
		return value;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
}
