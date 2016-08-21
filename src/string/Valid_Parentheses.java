package string;

import java.util.LinkedList;

public class Valid_Parentheses {

    public boolean isValid(String s) {
    	if(s==null||s.length()==0)
    		return true;
        LinkedList<Character> stack = new LinkedList<Character>();
    	stack.add(s.charAt(0));
    	for(int i=1;i<s.length();i++){
    		if(s.charAt(i)==']'){
    			if(stack.isEmpty()||stack.pollLast()!='[')
    				return false;
    		}else if(stack.isEmpty()||s.charAt(i)==')'){
    			if(stack.pollLast()!='(')
    				return false;
    		}else if(stack.isEmpty()||s.charAt(i)=='}'){
    			if(stack.pollLast()!='{')
    				return false;
    		}else{
    			stack.add(s.charAt(i));
    		}
    	}
    	if(stack.isEmpty())
    		return true;
    	else
    		return false;
    }
	public static void main(String[] args) {
		System.out.println(new Valid_Parentheses().isValid("(()"));
	}

}
