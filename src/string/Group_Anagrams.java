package string;
import java.util.*;
public class Group_Anagrams {
	
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> re = new ArrayList<List<String>>();
        if(strs==null||strs.length==0)
        	return re;
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        Arrays.sort(strs);
        for(String s : strs){
        	char[] sChars = s.toCharArray();
        	Arrays.sort(sChars);
        	String sSort = String.valueOf(sChars);
        	if(!map.containsKey(sSort))
        		map.put(sSort, new ArrayList<String>());
        	map.get(sSort).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
    
	public static void main(String[] args) {
		char[]chs = new char[]{'1','9','1'};
		chs[1]+=65535;
		String s = String.valueOf(chs);
		System.out.println(s);
	}
}
