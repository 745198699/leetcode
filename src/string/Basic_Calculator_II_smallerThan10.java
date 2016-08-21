package string;
import java.util.Stack;  
public class Basic_Calculator_II_smallerThan10 {
	public int calculate(String s) {
		int re=0;
		if(s==null||s.length()==0)
			return re;
		s=s.trim();
		s = MidToAfter(s);
		
		return Compute(s);
	}
	
	//计算后缀表达式
	public int Compute(String s){
		Stack<Integer> stack = new Stack<>();
		char[]chs = s.toCharArray();
		for(char ch : chs ){
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
				int num2 = stack.pop();
				int num1 = stack.pop();
				int numRe= 0;
				switch(ch){
				case '+':
					numRe=num1+num2;
					break;
				case '-':
					numRe = num1 - num2;
					break;
				case '*':
					numRe = num1 * num2;
					break;
				case '/':
					numRe = num1 / num2;
					break;
				}
				stack.push(numRe);
			}else{
				stack.push(ch-'0');
			}
		}
		return stack.pop();
	}
	
	//讲中缀表达式转为后缀表达式  1 + 2 -> 1 2 +
	public String MidToAfter(String s){
		char [] chs = s.toCharArray();
		StringBuffer re = new StringBuffer() ;
		Stack<Character> stack = new Stack<>();
		for(char ch : chs){
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
				if(stack.isEmpty()||prio(ch,stack.peek())==1){
					//优先级高,入栈
					stack.push(ch);
				}else{
					//优先级一样或者低
					re.append(stack.pop());
					stack.push(ch);
				}
			}else{
				re.append(ch);
			}
				
		}
		while(!stack.isEmpty()){
			re.append(stack.pop());
		}
		return re.toString();
	}
	
	//优先级 -1:op1<op2   0:op1=op2   1:op1>op2
	public int prio(char op1,char op2){
		if (op1 == '+' || op1 == '-')
		{
			if (op2 == '*' || op2 == '/')
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	
		if (op1 == '*' || op1 == '/')
		{
			if (op2 == '+' || op2 == '-')
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}
	

	
	public static void main(String[] args) {
//		int a = '2';
//		int b = a - '0';
//		System.out.println(b);
		int s = new Basic_Calculator_II_smallerThan10().calculate("1/0");
		System.out.println(s);
	}

}
