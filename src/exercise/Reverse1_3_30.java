package exercise;
public class Reverse1_3_30 {
	private static Node first;

	public Reverse1_3_30(){
		first = new Node();
		String s = "I'm going to give him an offer he can't refuse";
		String[] sa = s.split("\\s");
		Node cr = first;
		for(int i = 0; i < sa.length; i++){
			cr.item = sa[i];
			if(i != sa.length - 1)	cr.next = new Node();
			cr = cr.next;
		}
	}
	private class Node{
		String item;
		Node next;
	}

	public Node reverse(Node first){
		Node reverse = null;
		while(first != null){
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	public Node recursionReverse(Node first){
		Node reverse = null;
		return reverse;
	}
	public static void main(String[] args) {
		Reverse1_3_30 r = new Reverse1_3_30();
		r.reverse(first);
	}
}
