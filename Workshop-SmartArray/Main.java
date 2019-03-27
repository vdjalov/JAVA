import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		SmartArray list = new SmartArray();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.removeAt(0);
		list.removeAt(0);
		list.add(6);
		System.out.println(Arrays.toString(list.items()));	
		list.insert(0, 22);
		System.out.println(list.intSize());
		System.out.println(Arrays.toString(list.items()));	
		boolean contains = list.contains(0);
		System.out.println(contains);
		list.forEach(a -> {
			 System.out.print(a + " ");
		});
		System.out.println();
		
		
		
		

	}
}
