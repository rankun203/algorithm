package exercise;

import util.Timer;
import algs4.In;

/**
 * 动态连通性问题,基于<b>quick-union</b>算法<br>
 * 每个触点所对应的id[]元素都是同一个分量中的另一个触点的名称（也可能是它自己）———链接
 * @author mindfine
 */
public class UF1 {
	private int [] id;	//连通分量id，用触点作为索引
	private int count;	//分量数量
	
	/**
	 * 构造方法，初始化触点数据结构
	 * @param N 初始连通分量的数量
	 */
	public UF1(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	/**
	 * 判断两个触点是否连接
	 * @param p 第一个触点。
	 * @param q 第二个触点。
	 * @return 如果两个触点已经连接，则返回true； 如果两个触点未连接则返回false。
	 */
	public boolean connected(int p, int q) {
		return (find(q) == find(p));
	}
	/**
	 * 查找指定触点 p 的连通分量<br>
	 * 从一个节点得到该节点id[p]对应的节点，然后让p等于那个节点，<br>
	 * 再次检查那个节点（已经由p来指向）的id[p]对应的节点，然后再顺着链接找下去。
	 * @param p 指定触点 p
	 * @return 触点 p 的连通分量索引
	 */
	public int find(int p) {
		while(p != id[p])	p = id[p];
		return p;
	}
	/**
	 * 将 p 和 q 归到同一个分量中。
	 * <ol>
			<li>找到要归并到一起的两个分量的根节点</li>
			<li>如果他们的根节点相同则什么都不做</li>
			<li>把一个分量的根节点指向另一个分量的根节点，从而让这两个分量归为一个分量</li>
			<li>把分量总数减一 (二分量合一)</li>
		</ol><br>
	 * @param p 触点 p
	 * @param q 触点 q
	 */
	public void union(int p, int q){
		int qRoot = find(q);
		int pRoot = find(p);
		if(qRoot == pRoot)	return;

		id[qRoot] = id[pRoot];
		
		count--;
	}
	/**
	 * 连通分量的数量
	 * @return 连通分量的数量
	 */
	public int count() {
		return count;
	}

	/**
	 * 测试用例，输入一个 .txt文件，解析其中的所有触点，并建立连通分量。
	 */
	public static void main(String[] args) {
		In in = new In("largeUF.txt");
		int [] ints = in.readAllInts();
		int N = ints[0];
		UF1 uf = new UF1(N);
Timer t = new Timer();//计时开
		for(int i = 1; i < ints.length; i++){
			int p = ints[i];
			int q = ints[++i];
			if(uf.connected(p, q))	continue;
			uf.union(p, q);
System.out.println(p + " " + q);
		}
System.err.println("********************************************************* - " + t.round() + "ms");
			In in1 = new In("mediumUF.txt");
			int [] ints1 = in1.readAllInts();
			int N1 = ints1[0];
			UF1 uf1 = new UF1(N1);
t.round();//计时开始
			for(int i = 1; i < ints1.length; i++){
				int p = ints1[i];
				int q = ints1[++i];
				if(uf1.connected(p, q))	continue;
				uf1.union(p, q);
System.out.println(p + " " + q);
			}
System.err.println("********************************************************* - " + t.round() + "ms");
	}

}
