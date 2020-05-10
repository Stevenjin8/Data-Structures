
public class ArrayList {
	
	private int[] arr = new int[2];
	
	private int last = 0;
	
	/***********************
	 * setters and getters *
	 ***********************/

	/******************************
	 * end of setters and getters *
	 *******************************/
	
	public void doubleArray() {
		int[] newArr = new int[arr.length*2];
		for (int x=0; x<last; x++) {
			newArr[x] = arr[x];
		}
		this.arr = newArr;
	}
	
	public void halfArray() {
		int[] newArr = new int[arr.length/2];
		for (int x=0; x<last; x++) {
			newArr[x] = arr[x];
		}
		this.arr = newArr;
	}
	
	public void updateSize() {
		int currentSize = this.arr.length;
		
		if (last >= currentSize) {
			doubleArray();
		} else if (last <= currentSize/4) {
			halfArray();
		}
	}
	
	public void push(int x) {
		updateSize();
		arr[last] = x;
		last++;
	}
	
	public void insert(int x, int i) {
		for (int j = last; j>=i;j--) {
			arr[j] = arr[j-1];
		}
		arr[i] = x;
		last++;
		updateSize();
	}
	
	public void deleteLast() {
		last--;
		updateSize();
	}
	
	public void deleteItem(int i) {
		for (int x=0; x<last; x++) {
			if (arr[x] == i) {
				deleteIndex(x);
				break;
			}
		}
		updateSize();
	}
	
	public void deleteIndex(int i) {
		for (int x=i; x<last; x++) {
			arr[x] = arr[x+1];
		}
		last--;
		updateSize();
	}
	
	public int size() {
		return this.last;
	}
	
	public void print(Object j) {
		System.out.println(j);
	}
	
	public void print() {
		for (int x=0; x<last; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.print("\n");
	}
	
	/****************
	 * initializers *
	 ****************/
	
	public ArrayList(int[] arr) {
		for (int x: arr) {
			push(x);
		}
	}
	
	public ArrayList() {}
	
	/***********************
	 * end of initializers *
	 * *********************/
	
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		for (int x = 0; x< 100; x++) {
			arr.push(x);
		}
		
		for (int x=0; x< 68; x++) {
			arr.deleteLast();
		}
		
		arr.deleteItem(12);
		arr.insert(12, 12);
		
		arr.print();
		
		System.out.println(arr.arr.length);
	}
	
}
