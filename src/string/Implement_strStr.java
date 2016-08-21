package string;

public class Implement_strStr {
	/*
	 * 判断 needle 是不是 haystack 子串
	 */
    public int strStr(String haystack, String needle) {
    	if(needle==null||needle.length()==0)
    		return 0;
    	if(haystack==null||haystack.length()==0)
    		return -1;
        int sub_len = needle.length();
        char subBegin = needle.charAt(0);
        for(int i=0;i<=haystack.length()-needle.length();i++){
        	if(haystack.charAt(i)!=subBegin)
        		continue;
        	else{
        		if(haystack.substring(i,i+sub_len).equals(needle))
        			return i;
        		else
        			continue;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(new Implement_strStr().strStr("012345", ""));
	}

}
