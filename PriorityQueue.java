
public class PriorityQueue {
	
	/*
	 * starting internal array size
	 */
	public static final int INIT_ARR_SIZE = 8;
	
	/*
	 * internal array to stores
	 */
	private int[] arr = new int[4];
	
	/*
	 * index of last filled element
	 */
	private int last = 0;
	
	/*
	 * doubles the size of internal array and copies
	 */
	private void doubleSize() {
		int[] newArr = new int[arr.length * 2];
		for (int x=0; x<=last; x++) {
			newArr[x] = arr[x];
		}
		arr = newArr;
	}
	
	/*
	 * halves the size of internal array and copies
	 */
	private void halfSize() {
		int[] newArr = new int[arr.length / 2];
		for (int x=0; x<last+1; x++) {
			newArr[x] = arr[x];
		}
		arr = newArr;
	}
	
	/*
	 * updates the size based on last
	 */
	private void updateSize() {
		if (last >= arr.length-1) {
			doubleSize();
		} else if (last <= arr.length/4) {
			halfSize();
		}
	}
	
	/*
	 * swaps two indices in array
	 */
	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
	
	/*
	 * percolates element up until parent is smaller
	 */
	private void percolateUp(int i) {
		while (i != 0 && arr[i] < arr[i/2]) {
			System.out.println(i);
			swap(i, i/2);
			i = i/2;
		}
	}
	
	/*
	 * percolates down until both children and larges
	 */
	private void percolateDown(int i) {
		while (2*i+1<=last && (arr[i] > arr[2*i] || arr[i] > arr[2*i + 1])) {
			System.out.println(last);
			if (arr[i] > arr[2*i] && arr[2*i] <= arr[2*i + 1]) {
				swap(i,2*i);
				i = 2*i;
			} else if (arr[i] > arr[2*i + 1] && arr[2*i] > arr[2*i + 1]) {
				swap(i,2*i + 1);
				i = 2*i + 1;
			}
		}
	}
	
	/*
	 * inserts element into queue
	 */
	public void insert(int x) {
		addToEnd(x);
		percolateUp(last);
	}
	
	/*
	 * returns and deletes first element
	 */
	public int pop() {
		int toReturn = arr[1];
		arr[1] = arr[last];
		last--;
		percolateDown(1);
		updateSize();
		return toReturn;
	}
	
	/*
	 * adds element to end and updates size
	 */
	private void addToEnd(int x) {
		updateSize();
		last++;
		arr[last] = x;
	}
	
	/*
	 * prints the internal array
	 */
	public void print() {
		for (int x: arr) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	
	/*
	 * returns depth of tree
	 */
	private int depth() {
		return depth(last);
	}
	
	/*
	 * helper function for depth.
	 * effectively, log_2(n)
	 */
	private int depth(int n) {
		if (n<=1) {
			return 1;
		} else {
			return 1+depth(n/2);
		}
	}
	
	/*
	 * raises a to the power of b recursively
	 */
	private int power(int a, int b) {
		if (b==0) {
			return 1;
		} else {
			return a*power(a,b-1);
		}
	}
	
	/****************
	 * initializers *
	 ****************/
	
	/*
	 * empty initializer
	 */
	public PriorityQueue() {}
	
	/*
	 * initializes given a list of values
	 */
	public PriorityQueue(int[] l) {
		for (int x: l) {
			addToEnd(x);
		}
		int d = depth();
		
		for (int j = d-2; j >= 0; j--) {
			for (int i=power(2,j); i < power(2,j+1); i++) {
				//print();
				percolateDown(i);
			}
		}
		
	}
		
	/***********************
	 * end of initializers *
	 ***********************/
	
	
}
