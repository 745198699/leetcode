package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Letter_Combinations_Phone {
	String[]phoneMap = {"","","abc","def","ghi","jlk","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
//		LinkedList<String> re = new LinkedList<String>();
//		//DFS
//		dfs(digits,0,re);
//		return re;
		
		
		
//		String[]phoneMap = {"","","abc","def","ghi","jlk","mno","pqrs","tuv","wxyz"};
//		List<String> re = new LinkedList<String>();
//		List<String> tmp = new ArrayList<String>();
//		for(char number : digits.toCharArray()){
//			int index = Character.getNumericValue(number);
//			String letters = phoneMap[index];
//			for(char letter : letters.toCharArray()){
//				for(String ss : re){
//					tmp.add(ss+letter);
//				}
//				if(re.isEmpty()){
//					tmp.add(""+letter);
//				}
//			}
//			re.clear();
//			re.addAll(tmp);
//			tmp.clear();
//		}
//		return re;
		
		//FIFO
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}

//	public void dfs(String digits,int index,LinkedList<String> re){
//		if(index==digits.length())
//			return;
//		int i = Character.getNumericValue(digits.charAt(index));
//		String letters = phoneMap[i];
//		for(char letter : letters.toCharArray()){
//			re.add(letter+"");
//			dfs(digits,index+1,re);
//		}
//	}

	public static void main(String[] args) {
		System.out.println(new Letter_Combinations_Phone().letterCombinations("23"));
	}

}
