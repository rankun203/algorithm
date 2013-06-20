package exercise;

import algs4.Out;
import algs4.StdRandom;

/**
 * @author mindfine
 * 生成测试用double值
 */
public class GenDouble {
	public static void main(String[] args) {
		int N = 1000000;
		
		Out out = new Out("millionDouble.txt");
		for(int i = 0; i < N; i++){
			out.println(StdRandom.random() * 1000000);
		}
		out.close();
	}
}
