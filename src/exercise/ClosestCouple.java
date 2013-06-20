package exercise;

import java.util.Arrays;

import algs4.In;

/**
 * @author mindfine
 * 编写一个程序，给定一个含有N个double值的数组a[]，在其中找到一对最接近的值，两者之差（绝对值）最小的两个数。
 * 程序在最坏的情况下所需的运行时间应该是线性对数级别的。
 */
public class ClosestCouple {
	
	public static void main(String[] args) {
		double [] d = new In("millionDouble.txt").readAllDoubles();
		for1(d);
	}
	public static void for1(double [] d){
		Arrays.sort(d);
		double n1 = 0.0;
		double n2 = 0.0;
		double minus = 0.0;
		double min = 0.0;
		for(int i = 0; i < d.length - 1; i++){
			minus = d[i+1] - d[i];
			if(i == 0)	{
				min = minus;
			}
			else if(min > minus){
				min = minus;
				n1 = d[i+1];
				n2 = d[i];
			}
		}
		
		System.out.println("smallest: " + n1 + " - " + n2 + " = " + min);
	}
}
