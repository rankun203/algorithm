package learn;
public class CopyStack {
	
	public static Stack<String> copy(Stack<String> ss){
		Stack<String> news = new Stack<String>();
		for(String s : ss)
			news.push(s);
		return news;
	}

	public static void main(String[] args) {
	}

}
