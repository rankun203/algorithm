package learn;
public class EvaluatePostfix {

	//5 16 + 3 3 / 9 * - 
	public double evaluate(String con){
		Stack<Double> vals = new Stack<Double>();
		String [] nos = con.split("\\s");
		String cur;
		for(int i = 0; i < nos.length; i++){
			cur = nos[i];
			Double val2 = 0.0;
			Double val1 = 0.0;
			if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")){
				val2 = vals.pop();
				val1 = vals.pop();				
			}
			if(cur.equals("+"))	vals.push( val1 + val2);
			else if(cur.equals("-"))	vals.push( val1 - val2);
			else if(cur.equals("*"))	vals.push( val1 * val2);
			else if(cur.equals("/"))	vals.push( val1 / val2);
			else vals.push(Double.parseDouble(cur));
		}
		return vals.pop();
	}
	
	public static void main(String[] args) {
		String infixCond= "( ( 5 + 16 ) - ( ( 3 / 3 ) * 9 ) )";
		String postfixCond = InfixToPostfix.infix2postfix(infixCond);
		System.out.println(new EvaluatePostfix().evaluate(postfixCond));
	}

}
