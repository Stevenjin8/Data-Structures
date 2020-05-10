
public class Queue {
	
	/*
	 * sufficiently sized array
	 */
	public final int  ARR_SIZE = 512;
	
	/*
	 * internal array to store elements
	 */
	private int[] arr = new int[ARR_SIZE];
	
	/*
	 * first occupied spot
	 */
	private int head = 0;
	
	/*
	 * first open spot
	 */
	private int tail = 0;
	
	/*
	 * returns first item in queue
	 */
	public int peek() {
		return arr[tail];
	}
	
	/*
	 * adds item to queue
	 */
	public void enqueue(int x) {
		arr[tail] = x;
		tail = (tail + 1) % ARR_SIZE;
	}
	
	/*
	 * removes first item inserted to queue
	 */
	public int dequeue() {
		int  toReturn = arr[head];
		head = (head + 1) % ARR_SIZE;
		return toReturn;
	}
	
	/*
	 * makes typing print faster
	 */
	public static void print(Object e) {
		System.out.println(e);
	}
}
