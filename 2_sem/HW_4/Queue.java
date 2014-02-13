	/*
	 * This interface describes the structure of a Queue.
	 * There is an array of elements: "items"
	 * items = [0..size - 1]
	 * Inv: size >= 0
	*/

public interface Queue {

	// pre:
	// post: items[size] = element
	//		size' = size + 1
	void push(Object element);
	
	// pre: size > 0
	// post: result = items[size]
	//		size' = size - 1
	Object pop();
	
	// pre:
	// post: result = size
	int size();
	
	// pre:
	// post: result = (size == 0)
	boolean isEmpty();
}
