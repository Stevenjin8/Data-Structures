
public class ArrayList {
	
	/*
	 * internal array to store
	 */
	private int[] arr = new int[2];
	
	/*
	 * first empty index
	 */
	private int last = 0;
	
	/***********************
	 * setters and getters *
	 ***********************/

	/******************************
	 * end of setters and getters *
	 *******************************/
	
	/*
	 * doubles and copies the internal array
	 */
	private void doubleArray() {
		int[] newArr = new int[arr.length*2];
		for (int x=0; x<last; x++) {
			newArr[x] = arr[x];
		}
		this.arr = newArr;
	}
	
	/*
	 * halves and copies the internal array
	 */
	private void halfArray() {
		int[] newArr = new int[arr.length/2];
		for (int x=0; x<last; x++) {
			newArr[x] = arr[x];
		}
		this.arr = newArr;
	}
	
	/*
	 * updates the size of the array
	 */
	private void updateSize() {
		int currentSize = this.arr.length;
		
		if (last >= currentSize) {
			doubleArray();
		} else if (last <= currentSize/4) {
			halfArray();
		}
	}
	
	/*
	 * pushes item at the end of the ArrayList
	 */
	public void push(int x) {
		updateSize();
		arr[last] = x;
		last++;
	}
	
	/*
	 * inserts item at index
	 */
	public void insert(int x, int i) {
		for (int j = last; j>=i;j--) {
			arr[j] = arr[j-1];
		}
		arr[i] = x;
		last++;
		updateSize();
	}
	
	/*
	 * deletes last item
	 */
	public void deleteLast() {
		last--;
		updateSize();
	}
	
	/*
	 * deletes first occurrence of i
	 */
	public void deleteItem(int i) {
		for (int x=0; x<last; x++) {
			if (arr[x] == i) {
				deleteIndex(x);
				break;
			}
		}
		updateSize();
	}
	
	/*
	 * deletes item at index
	 */
	public void deleteIndex(int i) {
		for (int x=i; x<last; x++) {
			arr[x] = arr[x+1];
		}
		last--;
		updateSize();
	}
	
	/*
	 * returns size of array
	 */
	public int size() {
		return this.last;
	}
	
	/*
	 * print, but shortened so I don't have to type as much
	 */
	private void print(Object j) {
		System.out.println(j);
	}
	
	/*
	 * prints the array
	 */
	public void print() {
		for (int x=0; x<last; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.print("\n");
	}
	
	/****************
	 * initializers *
	 ****************/
	
	/*
	 * initializes array with arr
	 */
	public ArrayList(int[] arr) {
		for (int x: arr) {
			push(x);
		}
	}
	
	/*
	 * empty initializer
	 */
	public ArrayList() {}
	
	/***********************
	 * end of initializers *
	 ***********************/
	
}
