public class LinkedQueue implements Queue {
	private int size;
	private Node head;
	private Node tail;
	
	private class Node {
		Object value;
		Node next;

		public Node(Object value, Node next) {
			assert value != null;
			
			this.value = value;
			this.next = next;
		}
	}
	
	public void push(Object element) {
		assert element != null;
		
		Node OldTail = tail;
		tail = new Node(element, null);
		if (size != 0) {
			OldTail.next = tail;
		} else {
			head = tail;
		}
		size++;
	}
	
	public Object pop() {
		assert size > 0;
		
		Object value = head.value;
		head = head.next;
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
