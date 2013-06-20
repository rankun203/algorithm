package learn;
import algs4.StdOut;

public class Lg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StdOut.println(lg(31));
	}
	public static int lg(int N){
		int mark = 2;//底数
		int x = mark;
		int i = 0;
		while(!(x > N)){
			x *= mark;
			i++;
		}
		return i;
	}

}
