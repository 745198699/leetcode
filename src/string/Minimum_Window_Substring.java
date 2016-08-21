package string;

import java.util.HashMap;

public class Minimum_Window_Substring {

	public String minWindow(String s, String t) {
		//parse String t
		HashMap<Character,Integer> tMap = new HashMap<>();
		for(char tt:t.toCharArray()){
			tMap.put(tt, tMap.containsKey(tt)?tMap.get(tt)+1:1);
		}

		HashMap<Character,Integer> curMap = new HashMap<>();
		for(Character key:tMap.keySet())
			curMap.put(key, 0);
		//parse String s
		int p1=-1;int p2=-1;
		int minLen = Integer.MAX_VALUE;int p1Result=0;int p2Result=0;
		while(p2<s.length()-1 || isMatch(tMap,curMap)){
			if(!isMatch(tMap, curMap)){
				//p2++
				p2++;
				char newChar = s.charAt(p2);
				while(!tMap.containsKey(newChar)&&p2<s.length()-1){
					p2++;
					newChar = s.charAt(p2);
				}
				if(tMap.containsKey(newChar))
					curMap.put(newChar, curMap.get(newChar)+1);
			}else{
				if(p2-p1<minLen){
					p1Result = p1;
					p2Result = p2;
					minLen = p2-p1;
				}
				//p1++
				p1++;
				char removeChar = s.charAt(p1);
				while(!tMap.containsKey(removeChar)){
					if(p2-p1<minLen){
						p1Result = p1;
						p2Result = p2;
						minLen = p2-p1;
					}
					p1++;
					removeChar = s.charAt(p1);
				}
				if(tMap.containsKey(removeChar)){
					curMap.put(removeChar, curMap.get(removeChar)-1);
				}
			}
		}

		return minLen==Integer.MAX_VALUE?"":s.substring(p1Result+1,p2Result+1);
	}

	private boolean isMatch(HashMap<Character,Integer> tMap,HashMap<Character,Integer> curMap){
		for(Character key:tMap.keySet()){
			if(curMap.get(key)<tMap.get(key))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Minimum_Window_Substring().minWindow("B", "B"));
	}

}
