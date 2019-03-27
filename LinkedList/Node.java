
public class Node {

 private int element;
  Node prev;
  Node next;
 
		public Node(int element) {
			this.setElement(element);
			this.prev = null;
			this.next = null; 
		}

		
		public int getElement() {
			return element;
		}

		public void setElement(int element) {
			this.element = element;
		}
	
}
