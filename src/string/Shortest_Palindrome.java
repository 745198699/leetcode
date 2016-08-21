package string;
import java.lang.reflect.Array;
import java.util.*;
public class Shortest_Palindrome {


//	public String shortestPalindrome(String s) {
//		int j = 0;
//		for (int i = s.length() - 1; i >= 0; i--) {
//			if (s.charAt(i) == s.charAt(j)) 
//				j += 1; 
//		}
//		if (j == s.length()) { return s; }
//		String suffix = s.substring(j);
//		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
//	}

	public String shortestPalindrome(String s){
		if(s.length() <= 1){ return s; }
        String curs = s + " " + new StringBuilder(s).reverse().toString();
        int next[] = getNext(curs);
        return new StringBuilder(s.substring(next[curs.length()-1])).reverse().toString() + s;
	}
	
	private int[] getNext(String s){
		int [] next = new int[s.length()];
		//next[i]表示s 从0到i-1 最长公共前后缀,next[0]=0
		for(int i=1;i<s.length();i++){
			//dp求next[i]
			int j = next[i-1];
			while(j>0 && s.charAt(i)!=s.charAt(j)){
				j=next[j-1];
			}
			if(s.charAt(i)==s.charAt(j)){
				next[i]=j+1;
			}
				
		}
		
		return next;
	}
	
	public void test(){
		List<String> list = new ArrayList<String>(Arrays.asList("0","1","2"));
		for(String s:list){
			System.out.println(s);
			try{
				throw new Exception();
			}catch(Exception e){
				
			}
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(new Shortest_Palindrome().shortestPalindrome("abcbaa"));
		new Shortest_Palindrome().test();
	}
}
