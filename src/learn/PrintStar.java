package learn;
import algs4.StdDraw;
import algs4.StdOut;


public class PrintStar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(.01);
		StdDraw.setXscale(0, 15);
		StdDraw.setXscale(0, 15);
		nextStarLine(15);
	}

	private static int nextStarLine(int i) {
		if(i <= 0) return -1;
		for(int j = 0; j < i; j++){
			StdOut.print("* ");
		}
		StdDraw.point(i, i);
		StdOut.println();
		nextStarLine(--i);
		return 0;
	}
	

}
