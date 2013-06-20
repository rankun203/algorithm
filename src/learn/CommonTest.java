package learn;
import org.junit.Test;

import algs4.Out;
import algs4.StdOut;
import algs4.StdRandom;


public class CommonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		StdOut.println((char)('a' + 4));
//		StdOut.println(1 + 2 + "3");
		StdOut.println(Math.tan(Math.toRadians(135)));
	}
	@Test
	public static void generateTestInts(){
		int a = 0;
		Out out = new Out("largen.txt");
		for(int i = 0; i < 1000000; i++){
			a = StdRandom.uniform(20000000);
			out.println(a);
		}
		StdOut.println("OK");
	}
}
