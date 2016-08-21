package string;

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int max = Math.max(len1, len2);
        for(int i=0;i<max;i++){
        	Integer v1 = (i<len1)?Integer.parseInt(s1[i]):0;
        	Integer v2 = (i<len2)?Integer.parseInt(s2[i]):0;
        	int re = v1.compareTo(v2);
        	if(re!=0)
        		return re;
        	
        }
        return 0;
    }
}
