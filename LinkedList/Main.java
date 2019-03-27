import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();
		
		
		list.addLast(0);
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addLast(5);
		list.addLast(6);
		list.addFirst(7);
		int first = list.removeFirst();
		int last = list.removeLast();
		list.print();
		list.printBackwards();
		list.forEach(a -> {
			System.out.print(a + " ");
		});
		System.out.println("SIZE = " + list.size());
		int arr[] = list.toArray();
		System.out.println(Arrays.toString(arr));
		list.addAfter(3, 22);
		list.print();
		list.removeAfter(3);
		list.print();
		
		MyLinkedList newList = new MyLinkedList();
		newList.addLast(5);
		newList.addLast(2);
		newList.print();
		System.out.println("SIZE = " + newList.size());
		
	}
}
