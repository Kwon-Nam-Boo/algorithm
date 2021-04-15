package samsungTest;

public class ArrayQueue {
	
	private ArrayStack inbox, outbox;
	
	public ArrayQueue(int stackSize) {
		inbox = new ArrayStack(stackSize);
		outbox = new ArrayStack(stackSize);
	}
	
	public void offer(char item) {
		System.out.println("offer item " + item);
		inbox.push(item);
	}
	
	public char poll() {
		if (outbox.isEmpty()){
			while(!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(5);
		queue.offer('A');
		queue.offer('B');
		queue.offer('C');
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
	}
}
