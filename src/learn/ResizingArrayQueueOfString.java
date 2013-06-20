package learn;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfString<Item> {
	private Item a[] = (Item[])new Object[5];
	private int head;
	private int tail = -1;
	
	public void enqueue(Item i){
		if(tail == (a.length - 1))	resize(2 * a.length);
		a[++tail] = i;
	}
	public Item dequeue(){
		if(isEmpty())	throw new NoSuchElementException("queue is empty!");
		Item i = a[head++];
		if((tail - head) == a.length / 4)	resize(a.length / 2);
		return i;
	}
	public boolean isEmpty(){
		return head - 1 == tail;
	}
	public int size(){
		return tail - head + 1;
	}
	public void resize(int max){
		Item [] temp = (Item[])new Object[max];
		for(int i = head; i <= tail; i++)
			temp[i-head] = a[i];
		a = temp;
		tail = tail - head;
		head = 0;
	}
	
	public static void main(String[] args) {
		ResizingArrayQueueOfString<Integer> q = new ResizingArrayQueueOfString<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
			System.out.print(q.dequeue());
			System.out.print(q.dequeue());
			System.out.print(q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
			System.out.print(q.dequeue());
		q.enqueue(7);
		q.enqueue(8);
			System.out.print(q.dequeue());
			System.out.println(q.dequeue());
		System.out.println(q.size() + " left on queue.");
	}
}
