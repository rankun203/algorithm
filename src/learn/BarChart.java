package learn;
import java.awt.Font;

import algs4.StdDraw;

public class BarChart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 8;
		int l = 20;
		int r = 130;
		
		double [] doubles = {10.2, 12.5, 18.223, 5.3, 9.3, 120.362, 12.7, 52.852, 45.62, 45.85, 423.63};
		int[] inRange = inRange(N, l, r, doubles);
		
		//draw barChart
		
		//initial
		int max = inRange[0];
		for(int i = 0; i < inRange.length; i++){
			if (max < inRange[i]) max = inRange[i];
		}
		StdDraw.setXscale(0, N * 150);//150 = space:50 + area:100
		StdDraw.setYscale(0, max + max * 0.1);
		double horizontalOffset = max * 0.05;
		double verticalOffset = N * 150 * 0.05;
		StdDraw.line(0, horizontalOffset, N * 150, horizontalOffset);
		StdDraw.line(verticalOffset, 0, verticalOffset, doubles.length);
		
		for(int i = 0; i < N * 150; i ++){	//horizontal site
//			StdDraw.text(50 + 150 * i + 50 - verticalOffset, horizontalOffset - horizontalOffset * 0.5, "" + l + ((r - l) / N) * i);
		}
		
		StdDraw.setFont(new Font("", Font.PLAIN, 10));
		for(int i = 0; i < inRange.length; i++){
			double x = 50 + 150 * i + 50 - verticalOffset;
			double y = horizontalOffset + inRange[i] / 2.0;
			double halfWidth = 50;
			double halfHeight = y - horizontalOffset;
			StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			double ll = l + ((r - l) / N) * i;
			double rr = ll + ((r - l) / N);
			StdDraw.text(x, inRange[i] + max * 0.03 + horizontalOffset, "(" + ll + ", " + rr + ") " + inRange[i]);
		}
	}

	private static int[] inRange(int N, int l, int r, double[] doubles) {
		double rangeUnit = (r - l) / N;
		int[] inRange = new int[N];
		for(int j = 0; j < doubles.length; j++){
			for(int i = 0; i < N; i++){
				if(doubles[j] > l + (rangeUnit * i) && doubles[j] < l + (rangeUnit * (i + 1)))	inRange[i]++;
			}			
		}
		return inRange;
	}

}
