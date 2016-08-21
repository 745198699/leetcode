package string;

import java.util.*;

public class Simplify_Path {
	
	public String simplifyPath(String path) {
		String dirs[] = path.split("/");
		String stack[] = new String[dirs.length];
		int ptr=0;
		for(String dir : dirs){
			if(dir.equals(".")||dir.equals(""))  //  /./ 或者 //
				continue;
			else if(dir.equals("..")){
				if(ptr>0)
					ptr--;
			}
			else
				stack[ptr++]=dir;
				
		}
		
		StringBuffer res = new StringBuffer();
		for(int i=0;i<ptr;i++)
			res.append("/").append(stack[i]);
		
		return res.length()==0?"/":res.toString();
	}
    public String simplifyPath2(String path) {
    	Deque<String> stack = new LinkedList<>();
        path = path.replaceAll("//", "/");
        String[]p = path.split("/");
        for(String s:p){
        	if(s.equals("..")){
        		if(!stack.isEmpty())
        			stack.pop();
        	}
        	else if(s.equals("."))
        		continue;
        	else if(!s.equals(""))
        		stack.push(s);
        }
        String re ="";
        for(String dir:stack)
        	re = "/"+dir+re;
        if(re.isEmpty())
        	return "/";
        return re.toString();
    }

	public static void main(String[] args) {
		System.out.println(new Simplify_Path().simplifyPath("/.."));
	}

}
