package learn;
import java.util.Iterator;


public class ArrayStack<Item> implements Iterable<Item>{
	private Item []a = (Item[])new Object[1];
	private int N;
	
	public void push(Item i){
		if(N == a.length)	resize(2 * a.length);
		a[N++] = i;
	}
	public Item pop(){
		Item i = a[--N];//移除栈顶的元素
		a[N] = null;//避免对象游离
		if(N > 0 && N == a.length / 4)	resize(a.length / 2);
		return i;
	}
	public int size(){
		return N;
	}
	private void resize(int max){
		Item [] temp = (Item[])new Object[max];
		for(int i = 0; i < N; i++)	temp[i] = a[i];
		a = temp;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ArrayStackIterator();
	}
	private class ArrayStackIterator implements Iterator<Item>{
		int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}
		@Override
		public Item next() {
			return a[--i];
		}
		@Override
		public void remove() {}
	}
	

	public static void main(String[] args) {
		ArrayStack<String> s = new ArrayStack<String>();
		s.push("ha, ha~~~~");
		s.push(", ha~~~~");
		s.push("a, ha~~~~");
		s.push("h,ha~~~~");
		s.push("ha, ha~~~~");
		s.push("ha,ha~~~~");
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push("ha,~~~~");
		s.push("ha,~~~");
		s.push("h,~~~");
		s.push("ha, ha~~");
		System.out.println(s.pop());
		s.push("ha, ha~~~~");
		s.push("h,~~~");
		s.push("ha~~~~");
		s.push("h~~");
		System.out.println(s.size());
		for(String str: s)
			System.out.println(str);
	}
}
