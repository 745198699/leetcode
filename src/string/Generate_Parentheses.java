package string;
import java.util.*;
public class Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backTrack(list,"",  0, 0, n);
		return list;
	}
	
	private void backTrack(List<String> list,String cur,int open,int close, int n){
		if(cur.length()==2*n){
			list.add(cur);
			return;
		}
		
		if(open<n)
			backTrack(list, cur+"(", open+1, close, n);
		
		if(close<open)
			backTrack(list, cur+")", open, close+1, n);
	}

	public static void main(String[] args) {
		System.out.println(new Generate_Parentheses().generateParenthesis(3));
	}
}
