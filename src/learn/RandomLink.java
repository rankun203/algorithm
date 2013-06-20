package learn;
import java.awt.Color;

import algs4.StdDraw;
import algs4.StdOut;
import algs4.StdRandom;


public class RandomLink {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 5;//count of point
		double P = 0.6;//probability of line each point
		double r = 150;
		
		//initial
		StdDraw.setXscale(0, 400);
		StdDraw.setYscale(0, 400);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.001);

		//draw circle
		StdDraw.circle(200, 200, r);
		
		//draw and save point
		double degress = 360 / N;
		double [][] point = new double[N][2];//array to save all point
		for(int i = 1; i <= N; i++){
			double [] p = genPoint(degress, r);
			point[i-1][0] = p[0];
			point[i-1][1] = p[1];
			drawPoint(p[0], p[1]);
			degress = 360 * (i + 1) / N;
		}
		
		//random link
		link(point, P);
	}
	private static double[] genPoint(double d, double r){
		double k = Math.tan(Math.toRadians(d));
		double x = 0.0;
		double y = 0.0;
		if(d >= 0 && d <= 90){
			x = 200 + Math.sqrt((r * r) / (1 + k * k));
			y = 200 + Math.sqrt((k * k * r * r) / (1 + k * k));
		} else if(d > 90 && d <= 180){
			k = Math.abs(k);
			x = 200 - Math.sqrt((r * r) / (1 + k * k));
			y = 200 + Math.sqrt((k * k * r * r) / (1 + k * k));
		} else if(d > 180 && d <= 270){
			k = Math.abs(k);
			x = 200 - Math.sqrt((r * r) / (1 + k * k));
			y = 200 - Math.sqrt((k * k * r * r) / (1 + k * k));
		} else if(d > 270 && d <= 360){
			k = Math.abs(k);
			x = 200 + Math.sqrt((r * r) / (1 + k * k));
			y = 200 - Math.sqrt((k * k * r * r) / (1 + k * k));
		}
		
		double [] p = {x, y};
		return p;
	}
	private static void drawPoint(double x, double y) {
StdOut.println("(" + x + ", " + y + ")");
		double oldPenRadius = StdDraw.getPenRadius();
		StdDraw.setPenRadius(0.008);
		StdDraw.point(x, y);
		StdDraw.setPenRadius(oldPenRadius);
	}
	private static void link(double[][] point, double p){
		Color oldColor = StdDraw.getPenColor();
		StdDraw.setPenColor(StdDraw.GRAY);
		for(int i = 0; i < point.length - 1; i++){
			for(int j = i; j < point.length; j++){
				boolean linkable = StdRandom.bernoulli(p);
				if(linkable) StdDraw.line(point[i][0], point[i][1], point[j][0], point[j][1]);
			}
		}
		StdDraw.setPenColor(oldColor);
	}
}
