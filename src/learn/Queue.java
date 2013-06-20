package learn;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node head;
	private Node tail;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	public void enqueue(Item i){
		Node oldTail = tail;
		tail = new Node();
		tail.item = i;
		if(isEmpty())	head = tail;
		else oldTail.next = tail;
		N++;
	}
	public Item dequeue(){
		Item item = head.item;
		head = head.next;
		N--;
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item>{
		@Override
		public boolean hasNext() {
			return !isEmpty();
		}
		@Override
		public Item next() {
			return dequeue();
		}
		@Override
		public void remove() {}
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.enqueue("to");
		q.enqueue("be");
		q.enqueue("or");
		q.enqueue("not");
		q.enqueue("that");
		q.enqueue("is");
		
		for(String s : q){
			System.out.print(s + " ");			
		}
	}
}
