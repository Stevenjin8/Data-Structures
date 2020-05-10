
public class Stack {
	/*
	 * sufficiently sized array
	 */
	public final int  ARR_SIZE = 512;
	
	/*
	 * internal array to store elements
	 */
	private int[] arr = new int[ARR_SIZE];
	
	/*
	 * top of the stack
	 */
	private int top = 0;
	
	/*
	 * returns first item in queue
	 */
	public int peek() {
		return arr[top];
	}
	
	/*
	 * adds item to queue
	 */
	public void push(int x) {
		top++;
		arr[top] = x;
	}
	
	/*
	 * removes first item inserted to queue
	 */
	public int pop() {
		int  toReturn = arr[top];
		top++;
		return toReturn;
	}
	
	/*
	 * makes typing print faster
	 */
	public static void print(Object e) {
		System.out.println(e);
	}
}
