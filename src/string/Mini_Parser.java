package string;
import java.util.*;
public class Mini_Parser {
	public NestedInteger deserialize(String s) {
		Stack<NestedInteger>stack = new Stack<NestedInteger>();
		char[]chars = s.toCharArray();
		int curValue = 0;
		boolean flag = true;//标记正负号
		for(int i=0;i<chars.length;i++){
			char c=chars[i];
			if(c=='-'){
				flag = false;
				continue;
			}
			if(c>='0'&&c<='9'){
				curValue = curValue*10+(c-'0');
				continue;
			}
			if(c=='['){
				NestedInteger cur = new NestedInteger();
				stack.push(cur);
				continue;
			}
			if(c==','){
				if(chars[i-1]!=']'){
					stack.peek().add(new NestedInteger(flag?curValue:0-curValue));
					curValue=0;
					flag = true;
				}
				continue;
			}
			if(c==']'){
				NestedInteger top = stack.pop();
				if(chars[i-1]!=']'&&chars[i-1]!='['){
					top.add(new NestedInteger(curValue));
					curValue=0;flag=true;
				}
				if(stack.isEmpty())
					return top;
				else
					stack.peek().add(top);
				continue;
			}
		}
		if(s.charAt(0)!='[')
			return new NestedInteger(flag?curValue:0-curValue);

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mini_Parser().deserialize("[]");
	}

}


