
import java.util.function.Consumer;

public class SmartArray {

	private int length;
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
	private int capacity;
	private int [] array;
	
		public SmartArray() {
			this.capacity = DEFAULT_INITIAL_CAPACITY;
			this.array = new int[this.capacity];
			this.length = 0;
		}
	
		// Traverse and print 
		public void forEach(Consumer<Integer> consumer) {
			
			for(int i = 0; i < this.length; i++) {
				int element = this.array[i];
				consumer.accept(element);
			}	
		}
		
		// Check if in there
		public boolean contains(int element) {
			for(int i = 0 ; i < this.length; i++) {
				int number = this.array[i];
					if(number == element) {
						return true;
					}
			}
			return false;
		}
		
		// Inserting an element at a given position 
		public void insert(int index, int element) {
			if(index < 0 || index > this.length) {
				throw new IndexOutOfBoundsException("Index out of bounds");
			}
			
			if(this.length == this.capacity) {
				resize();
			}
			
			if(index == this.length) {
				this.add(element);
			}else {
				int arrayCopy[] = this.array.clone();
				this.array = new int[this.capacity];
				System.arraycopy(arrayCopy, 0, this.array, 0, index);
				array[index] = element;
				System.arraycopy(arrayCopy, index, array, index + 1, arrayCopy.length - (index + 1));
				this.length++;
			}
		}
		
		
		
		//Removing the element at the asked index
		public int removeAt(int index) {
			if (index < 0 || index > this.length - 1) {
				throw new IndexOutOfBoundsException("Index out of bounds");
			}			
			int value = this.array[index];
			int arrayCopy[] = shift(index).clone();
			shrink(arrayCopy);
			this.array = new int[this.capacity];
			System.arraycopy(arrayCopy, 0, this.array, 0, arrayCopy.length);
			this.length--;
			return value;
	}	
	
		// Shrink if possible to save memory
		private void shrink(int[] arrayCopy) {
			if(arrayCopy.length * 2 < this.capacity) {
				this.capacity = this.capacity / 2;
			}
		}

		//Shift all left
		private int[] shift(int index) {
			int arrayCopy[] = new int[this.length -1];
				int count = 0;
				for(int i = 0; i < this.length; i++) {
					if(i != index) {
					  arrayCopy[count] = this.array[i];
					  count++;
					}
				}
				return arrayCopy;
		}

		
		// Add element at the end of the array
		public void add(int element) {
			if(this.length == this.capacity) {
				 resize();
			}
			array[length] = element;
			this.length++;
		}


		// Resizing the array
		private void resize() {
			int arrayCopy[] = array.clone();
			this.capacity = this.capacity * 2;
			this.array = new int[this.capacity];
	
				System.arraycopy(arrayCopy, 0, array, 0, arrayCopy.length);
		}


		// Returns the size of the array
		public int intSize() {
			return this.length;
		}
		
		// Returns an array full with the elements
		public int[] items(){
			int arrayCopy[] = new int[this.length];
			System.arraycopy(this.array, 0, arrayCopy, 0, this.length);
			return arrayCopy;
		}
		
		
		
		
		
		
		
	
		
		
	
}
