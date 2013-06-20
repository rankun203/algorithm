package learn;
import algs4.StdOut;

public class ArrayEcs{

	/**
	 * @param args:no parameter
	 */
	public static void main(String[] args) {
		boolean [][] a = new boolean[20][10];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				if(gcd(i, j) == 1){
					a[i][j] = true;
				}
			}
		}
		print(a);
	}
	private static void print(boolean[][] a) {
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				StdOut.printf("%b\t", a[i][j]);
			}
			StdOut.println();
		}
	}
	/**
	 * @param a an Integer
	 * @param b an Integer
	 */
	public static int gcd(int a, int b){
		if (b == 0) return a;
		int r = a % b;
		return gcd(b, r);
	}

}
