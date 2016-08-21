package string;

public class Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
			return "";
		StringBuilder res = new StringBuilder();
		String s0 = strs[0];
		for(int i=0;i<s0.length();i++){
			char curChar = s0.charAt(i);
			boolean end = false;
			for(String s:strs){
				if(i>=s.length()||curChar!=s.charAt(i)){
					end=true;
					break;
				}
			}
			if(!end)
				res.append(curChar);
			else
				break;
		}
		return res.toString();
	}
	
}
