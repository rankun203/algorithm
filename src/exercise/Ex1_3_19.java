package exercise;

public class Ex1_3_19 {
	private String item;
	private Ex1_3_19 next;
	private static Ex1_3_19 first;
	
	
	/**
	 * 接受一个链表节点作为参数并删除该节点的后续节点（如果参数节点或参数节点的后续节点为空则什么也不做）
	 * @param e 指定的链表节点
	 */
	public static void removeAfter(Ex1_3_19 e){
		if(e != null && e.next != null){
			e.next = null;
		}
	}
	/**
	 * 接受两个链表节点作为参数，将第二个结点插入链表并使之成为第一个结点的后续结点（如果两个参数为空则什么也不做）
	 * @param e1 指定的结点
	 * @param e2 要插入的结点
	 */
	public static void insertAfter(Ex1_3_19 e1, Ex1_3_19 e2){
		if(e1 != null && e2 != null){
			e2.next = e1.next;
			e1.next = e2;
		}
	}
	/**
	 * 接受一条链表和一个字符串key作为参数，删除链表中所有item域为key的结点
	 * @param e 指定的链表
	 * @param key 要搜索的字符串
	 */
	public static void remove(Ex1_3_19 e, String key){
		Ex1_3_19 cr = e;
		Ex1_3_19 prev = null;
		while(cr !=null){
			if(cr.item.equals(key)){
				prev.next = cr.next;
			}
			prev = cr;
			cr = cr.next;
		}
	}
	public static void delete(int k) {
		Ex1_3_19 prev = null;
		Ex1_3_19 cr = first;
		for(int i = 1; i <= k; i++){
			if(i == k){
				prev.next = cr.next;
			}
			prev = cr;
			cr = cr.next;
		}
	}
	public static boolean find(String k){
		//从头开始找
		boolean finded = false;
		Ex1_3_19 cr = first;
		while ( finded == false ){
			if(cr != null){//在当前节点不为空的情况下（因为这个节点是有上一个节点.next指向的，可能上一个节点是末尾节点，那么这个节点就为空）
				if(cr.item.equals(k)) {//找到就大功告成
					finded = true;
				} else {//找不到就把当前指针继续后移
					cr = cr.next;
				}
			} else {//找到末尾都没有就不找了
				break;
			}
		}
		return finded;
	}
	public static void main(String[] args) {
		//初始化整个链表
		first = new Ex1_3_19();
		String s = "I'm going to give him an offer he can't refuse";
		String[] sa = s.split("\\s");
		Ex1_3_19 cr = first;
		for(int i = 0; i < sa.length; i++){
			cr.item = sa[i];
			if(i != sa.length - 1)	cr.next = new Ex1_3_19();
			cr = cr.next;
		}

		System.out.println(first.toString());

		//定义一个变量从第一个节点开始扫描，直到最后一个节点。
		//再定义一个变量记录上一个节点，在最后删除末尾节点的时候，让该变量.next指向null。
		Ex1_3_19 e = first;
		Ex1_3_19 back = null;
		for(int i = 0; i < Long.MAX_VALUE; i++){
			if(e.next == null){
				back.next = null;
				break;
			}
			back = e;
			e = e.next;
		}
		
		System.out.println(first);
		delete(4);
		System.out.println(first.toString());
		System.out.println(find("haha"));
		//test method remove()
		remove(first, "him");
		System.out.println(first);
		
	}
	@Override
	public String toString() {
		String str = "";
		Ex1_3_19 cr = first;
		for(int i = 0; i < Long.MAX_VALUE; i++){
			if(cr == null)	break;
			str += cr.item + ", ";
			cr = cr.next;
		}
		return str;
	}
	
}
