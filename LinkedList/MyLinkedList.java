import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

public class MyLinkedList {

	private int size = 0;
	private Node head;
	private Node tail;
	
		public MyLinkedList(){
			this.head = null;
			this.tail = null;
		}
		
		
		
	// Remove an element after a specific index
	public void removeAfter(int index) {
		if(index < 0 || index > this.size ) {
			throw new InvalidDnDOperationException("Index out of bounds");
		}
		
		Node start = head;
		int count = 1;
			while(start != null) {
					if(count == index) {
						Node nextNextNode = start.next.next;
						start.next = nextNextNode;
						nextNextNode.prev = start;
					}
				count++;
				start = start.next;
			}
	}
		
		
	// Add after a specific index 	
	public void addAfter(int index, int element){
		if(index < 0 || index > this.size ) {
			throw new InvalidDnDOperationException("Index out of bounds");
		}
		
		Node start = head;
		int count = 1;
			while(start != null) {
				if(count == index){
					Node node = new Node(element);
					Node nextNode = start.next;
					start.next = node;
					node.prev = start;
					start = start.next;
					nextNode.prev = node;
					node.next = nextNode;
					break;
				}
				
				count++;
				start = start.next;
			}
		size++;
		
	}
		
	// Copy to an array
	public int[] toArray() {
		int array[] = new int[this.size];
		Node start = head;
		int indexCount = 0;
			while(start != null) {
				array[indexCount] = start.getElement();
				start = start.next;
				indexCount++;
			}
		return array;
	}
		
	//Removing the last element
	public int removeLast() {
		if(this.size() == 0) {
			throw new InvalidDnDOperationException("Remove called for a collection with size 0");
		}
		
		Node node = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		return node.getElement();
	}
			
	//Removing the first element	
	public int removeFirst() {
		if(this.size() == 0) {
			throw new InvalidDnDOperationException("Remove called for a collection with size 0");
		}
		
		Node node = head;
		head = node.next;
		head.prev = null;
		size--;
		
		return node.getElement();
	}
		
	//Adding element at the end 
	public void addLast(int element) {
		
		if(this.size == 0) {
			head = new Node(element);
			tail = head;
		}else {
			Node node = new Node(element);
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}
			
		
	//Adding an element at the front 	
	public void addFirst(int element) {
			
		if(this.size == 0) {
			head = new Node(element);
			tail = head;
		}else {
			Node node = new Node(element);
			node.next = head;
			head.prev = node;
			head = node;
		}
		this.size++;
	}
		
	// Returns array Size
		public int size() {
			return this.size;
		}
		
	// For Each print
		public void forEach(Consumer<Integer> consumer) {
			if(this.size > 0) {
			Node start = head;
				while(start != null){
				consumer.accept(start.getElement());
				start = start.next; 
				}
				System.out.println();
			}
		}	
		
		
	
	// Print starting First
	public void print() {
		if(this.size > 0) {
		Node start = head;
			while(start != null){
			System.out.print(start.getElement() + " ");
			start = start.next; 
			}
			System.out.println();
		}
	}
	
	
	//Print starting last - Tail
	public void printBackwards() {
		if(this.size > 0) {
			Node end = tail;
				while(end != null){	
				System.out.print(end.getElement() + " ");
				end = end.prev; 
			}
				System.out.println();
		}
		
	}
		
	
}
