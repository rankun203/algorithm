package learn;
public class Parenthess {

	public static void main(String[] args) {
		String parenthess = "[][][](()(){}){}";
		System.out.println(parenthess + ":" + pairedParenthess(parenthess));
	}
	public static boolean pairedParenthess(String p){
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < p.length(); i++){
			if(isFrontParenthesis(p.charAt(i)))	s.push(p.charAt(i));
			else if(isBackParenthesis(p.charAt(i)))	if(!(isPaired(s.pop(), p.charAt(i))))	return false;
		}
		if(s.size() != 0)	return false;
		return true;
	}
	private static boolean isPaired(char a, char b){
		if(a == '[' && b == ']')	return true;
		else if(a == '(' && b == ')')	return true;
		else if(a == '<' && b == '>')	return true;
		else if(a == '{' && b == '}')	return true;
		else return false;
	}
	private static boolean isFrontParenthesis(char c){
		if(c == '[' || c == '(' || c == '{' || c == '<')	return true;
		return false;
	}
	private static boolean isBackParenthesis(char c){
		if(c == ']' || c == ')' || c == '}' || c == '>')	return true;
		return false;		
	}
}
