package string;
import java.io.IOException;
import java.util.*;

public class Word_Ladder_II {
	
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
//        boolean[]flag=new boolean[wordList.size()];
        Map<String, Boolean>flag = new HashMap<>();
        for(String s:wordList)
        	flag.put(s, false);
    	//start backtrack
        backTracking(beginWord, endWord, wordList, flag, results, cur);
        
    	return results;
    }
    
    private void backTracking(String beginWord, String endWord,Set<String>wordList, 
    		Map<String, Boolean>flag, List<List<String>> results, List<String>cur){
    	
    	//首先判断begin和end是否只差一个char
		if(cmpString(beginWord, endWord)){
			cur.add(endWord);
			if(results.isEmpty())
				results.add(new ArrayList<>(cur));
			else if(cur.size()<results.get(0).size()){
				results.clear();
				results.add(new ArrayList<>(cur));
			}else if(cur.size()==results.get(0).size()){
				results.add(new ArrayList<>(cur));
			}
			cur.remove(endWord);
			return;
		}
    	
    	for(String s:wordList){
    		if(flag.get(s))
    			continue;//标记位为true，表示已经用过了，无法继续使用
    		
    		if(cmpString(beginWord, s)&&(!flag.get(s))){//s和beginWord只差1且没用过
    			flag.put(s, true);
    			cur.add(s);
    			if(results.size()>0&&cur.size()>results.get(0).size()){
    				flag.put(s, false);
        			cur.remove(cur.size()-1);
					break;
    			}
    			backTracking(s, endWord, wordList, flag, results, cur);
    			flag.put(s, false);
    			cur.remove(cur.size()-1);
    		}
    			
    			
    	}
    }
    
    private	boolean cmpString(String s1, String s2){
    	//s1 和 s2如果只差一个char，返回true，否则返回fals
    	int count = 0;
    	char[]c1 = s1.toCharArray();
    	char[]c2 = s2.toCharArray();
    	for(int i=0;i<s1.length();i++){
    		if(c1[i]!=c2[i])
    			count++;
    	}
    	if(count==1)
    		return true;
    	else
    		return false;
    }
    
    public static void main(String[] args) {
    	
    	
//    	Arrays.asList("hot","dot","dog","lot","log");
		System.out.println(new Word_Ladder_II().findLadders("hit", "cog", 
				new HashSet<String>(Arrays.asList("hot","cog","dot","dog","hit","lot","log"))));
	}
}
