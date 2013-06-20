package learn;
import org.junit.Test;

import algs4.StdOut;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		int [] a = new In("tinyn.txt").readAllInts();//白名单
		Arrays.sort(a);
		In t = new In("largen.txt");
		while(!t.isEmpty()){
			int num = t.readInt();
			int n = rank(0, a.length - 1, a, num);
			if(n != -1){
				StdOut.println(num);
			}
		}
*/
	}
	@Test
	public void rankTest1(){
		int[] a = {2, 3, 5, 6, 7, 7, 7, 7, 8, 8, 9, 20, 23, 28, 29, 30};
		int key = 7;
		StdOut.println(count(a, key));
	}
	public static int rank(int lo, int hi, int[] a, int key){
		if(lo > hi) return -1;
		int mid = (hi - lo) / 2 + lo;
		if		(a[mid] > key) return rank(lo, --mid, a, key);
		else  if(a[mid] < key) return rank(++mid, hi, a, key);
		else                   return mid;
	}
	public static int rank(int[] a, int key){
		int mid = rank(0, a.length - 1, a, key);
		int leftTo = findMoreLeft(a, key, --mid) + 1;
		int rightTo = findMoreRight(a, key, ++mid) - 1;
		StdOut.println(key + ": " + leftTo + "-" +rightTo);
		return --leftTo;
	}
	public static int count(int[] a, int key){
		int mid = rank(0, a.length - 1, a, key);
		int leftTo = findMoreLeft(a, key, --mid) + 1;
		int rightTo = findMoreRight(a, key, ++mid) - 1;
		return rightTo - leftTo + 1;
	}
	public static int findMoreLeft(int[] a, int key, int pos){
		if(a[pos] != key) return pos;
		else return findMoreLeft(a, key, --pos);
	}
	public static int findMoreRight(int[] a, int key, int pos){
		if(a[pos] != key) return pos;
		else return findMoreRight(a, key, ++pos);
	}	
}
