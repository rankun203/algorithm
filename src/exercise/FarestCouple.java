package exercise;

import java.util.Arrays;

import algs4.In;

/**
 * @author mindfine
 * 编写一个程序，给定一个含有N个double值的数组a[]，在其中找到一对最遥远的值，两者之差（绝对值）最大的两个数。
 * 程序在最坏的情况下所需的运行时间应该是线性级别的。
 */
public class FarestCouple {
	
	public static void main(String[] args) {
		double [] d = new In("millionDouble.txt").readAllDoubles();
		greLog(d);
	}
	/**
	 * @param d double类型的数组
	 * 线性对数级别
	 */
	public static void greLog(double [] d){
		Arrays.sort(d);
		double minus = d[d.length - 1] - d[0];
		System.out.println("farest: " + d[d.length - 1] + " - " + d[0] + " = " + minus);
	}
}
