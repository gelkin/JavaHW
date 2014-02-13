public class ArrayQueueSingleton {
	private int size;
	private Object[] elements = new Object[10];
	private int end = elements.length - 1;
	private int start = elements.length - 1;
	
	// Inv: size >= 0 && end <= start
	
	// pre: 
	// post: size' = size + 1 && elements[size] = element 
	public void push(Object element) {
		assert element != null;
		 
		ensureCapacity(size + 1);
      	elements[end] = element;
      	end = (end + 1) % elements.length;
      	size++;
	}
	
	// pre: 
	// post: (size < capacity)? size' = 2*(size + 1) && end = size + 1 && start = size' - 1 : true
	private void ensureCapacity(int capacity) {
		if (capacity <= elements.length) {
			return;
		}
		Object newElements = new Object[2 * capacity];
		for (int i = 0; i < elements.length; i++) {
			newElements[i + (elements.length + 2)] = elements[i];
		}
		end = elements.length + 1;
		start = newElements.length - 1;
		elements = newElements;
	}
	
	// pre: size > 0
	// post: size' = size - 1 && (end != start)?
	// 					res = elements[end + 1] && elements[end + 1] = 0 && end' = end + 1
	// 						: res = elements[0] && elements[0] = 0 && end = 0
	public Object pop() {
		assert size > 0;
		
		Object value = peek();
		if (end != start) {
			elements[end + 1] = 0;
			end++;
		} else {
			elements[0] = 0;
			end = 0;
		}
		return value;
	}

	/* pre: size > 0
	// post: (end != start)? res = elements[end + 1] : res = elements[0]
	public Object peek() {
		assert  size > 0;
		
	
		if (end != start) {
			return elements[end + 1];
		} else {
			return elements[0];
		}
	}
	*/
	
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
