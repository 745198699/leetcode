package string;
import java.util.*;
public class Palindrome_Pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> results = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
	
		for(int i=0;i<words.length;i++) map.put(words[i], i);
		for(int i=0;i<words.length;i++){
	//			//单独处理 "" 情况
	//			if(words[i].equals("")){
	//				for(int j=0;j<words.length;j++){
	//					if(isPalindrome(words[j])&&i!=j){
	//						results.add(new ArrayList<>(Arrays.asList(j,i)));
	//					}
	//				}
	//			}
			for(int j=0;j<=words[i].length();j++){
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
	
				if(isPalindrome(str1)){
					String needAddToLeft = new StringBuffer(str2).reverse().toString();
					if(map.containsKey(needAddToLeft)&&map.get(needAddToLeft)!=i){
						results.add(new ArrayList<>(Arrays.asList(map.get(needAddToLeft),i)));
					}
				}
				if(isPalindrome(str2)){
					String needAddToRight = new StringBuffer(str1).reverse().toString();
					if(map.containsKey(needAddToRight)&&map.get(needAddToRight)!=i&&str2.length()!=0){
						results.add(new ArrayList<>(Arrays.asList(i,map.get(needAddToRight))));
					}
				}
			}
		}
	
		return results;
	}
	
	private boolean isPalindrome(String s){
		if(s.equals(""))
			return true;
		int start =0;
		int end = s.length()-1;
		while(start<=end){
			if(s.charAt(start)!=s.charAt(end))
				return false;
			else{
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Palindrome_Pairs().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
		//		System.out.println(new Palindrome_Pairs().palindromePairs(new String[]{"a",""}));
		System.out.println(new Palindrome_Pairs().palindromePairs(new String[]{"bat", "tab", "cat"}));
	}
}
