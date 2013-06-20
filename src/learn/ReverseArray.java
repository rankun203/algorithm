package learn;
import algs4.StdOut;


public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {{4, 6, 8, 9, 1}, {2, 5, 4, 7, 6}, {4, 8, 9, 7, 2}, {2, 4, 9, 3, 7}, {8, 9, 4, 7, 5}, {2, 3, 8, 5, 7}, {2, 8, 7, 9, 3}, {2, 1, 5, 8, 9}};
		printArr(a);
		a = exchange(a);
		StdOut.println();
		printArr(a);
	}
	public static int[][] exchange(int [][] a){
		int[][] b = new int[a[0].length][a.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}
	public static void printArr(int[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i] + ",");
		}
	}
	public static void printArr(int[][] a){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				StdOut.print(a[i][j] + ",");				
			}
			StdOut.println();
		}
	}


}
