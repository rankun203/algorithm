package learn;
import java.util.NoSuchElementException;

public class InfixToPostfix {

	public static void main(String[] args) {
//		String infixCond= "( 23 + 34 * 45 / ( 5 + 6 + 7 ) )";
		String infixCond= "( ( 5 + 16 ) - ( ( 3 / 3 ) * 9 ) )";
		String postfixCond = infix2postfix(infixCond);
		System.out.println(postfixCond);
	}
	public static String infix2postfix(String c){
		Stack<String> postfixStack = new Stack<String>();
		Stack<String> oprs = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		String [] nos = c.split("\\s");	//nos: number operator s
		for(int i = 0; i < nos.length; i++){
			String cur = nos[i];
			if(cur.equals("("));
			else if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/"))	oprs.push(cur);
			else if(cur.equals(")")){
				String opr = oprs.pop();
				String val2 = "";
				String val1 = "";
				try{
					val2 = vals.pop();					
				} catch (NoSuchElementException e) {
					val2 = postfixStack.pop();
				}
				try{
					val1 = vals.pop();
				} catch (NoSuchElementException e) {
					val1 = postfixStack.pop();
				}
				postfixStack.push(val1);
				postfixStack.push(val2);
				postfixStack.push(opr);
			} else {
				postfixStack.push(cur);
			}
		}
		Stack<String> temp = new Stack<String>();
		for(String s : postfixStack){
			temp.push(s);
		}
		return temp.cleanString();
	}
/*
	public static String infix2postfix(String c){
		String postfixCond = "";
		Stack<Character> oprs = new Stack<Character>();
		Stack<Double> vals = new Stack<Double>();
		String [] nos = c.split("\\s");	//nos: number operator s
		for(int i = 0; i < nos.length; i++){
			String cr = nos[i];
			if(cr.equals("("));
			else if(cr.equals("+") || cr.equals("-") || cr.equals("*") || cr.equals("/"))	oprs.push(cr.charAt(0));
			else if(cr.equals(")")){
				char opr = oprs.pop();
				double val2 = vals.pop();
				double val1 = vals.pop();
				if(opr == '+')	vals.push(val1 + val2);
				else if(opr == '-')	vals.push(val1 - val2);
				else if(opr == '*')	vals.push(val1 * val2);
				else if(opr == '/')	vals.push(val1 / val2);
			} else {
				vals.push(Double.parseDouble(cr));
			}
		}
		System.out.println(vals.pop());
		return postfixCond;
	}
*/
}
