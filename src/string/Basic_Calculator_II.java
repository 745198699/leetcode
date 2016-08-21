package string;

import java.util.Stack;

public class Basic_Calculator_II {
	public static void main(String[] args) {
		char c = 2;
		for(int i=0;i<100;i++)
			System.out.println(c++);
			
	}
	public int calculate(String s) {
		if(s == null || s.length() == 0) {
	        return 0;
	    }
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		int num =0;
		char [] chs = s.toCharArray();
		for(int i=0;i<=s.length();i++){//主意不是i<s.length() 这样做是为了处理最后一个数字和运算符
			char ch;
			if(i==s.length()){
				ch='e';//sentinel
			}else
				ch = chs[i];
			
			if(ch==' ')
				continue;
			if(Character.isDigit(ch)){
				num=(num*10+(ch-'0'));
			}else{
				if(sign=='+')
					stack.push(0+num);
				else if(sign=='-')
					stack.push(0-num);
				else if(sign=='*')
					stack.push(stack.pop()*num);
				else if(sign=='/')
					stack.push(stack.pop()/num);
				
				num=0;
				sign=ch;
				
			}
		}
		
		int re=0;
		for(int i:stack)
			re+=i;
		
		return re;
	}
}
