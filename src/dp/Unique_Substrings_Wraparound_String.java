package dp;

public class Unique_Substrings_Wraparound_String {
	
	public static void main(String[] args) {
		System.out.println(new Unique_Substrings_Wraparound_String().findSubstringInWraproundString("zaba"));
	}
	
	public int findSubstringInWraproundString(String p) {
		if(p.equals(""))
			return 0;
		
		int count[] = new int[26];
		int cur_max = 1;
		count[p.charAt(0)-'a']=1;
		for(int i=1;i<p.length();i++){
			char cur = p.charAt(i);
			char pre = p.charAt(i-1);
			if(cur-pre==1 || (cur=='a'&&pre=='z')){
				cur_max++;
			}else
				cur_max=1;
			
			count[cur-'a'] = Math.max(count[cur-'a'], cur_max);
		}
		
		int sum = 0;
		for(int i=0;i<26;i++){
			sum+=count[i];
		}
		return sum;
	}
	
	
//    public int findSubstringInWraproundString(String p) {
//    	int len = p .length();
//        int dp [][] = new int [len][len];
//    	
//        for(int l=1;l<=len;l++){
//        	for(int i=0;i<len-l+1;i++){
//        		int j = i+l-1;
//        		if(l==1){
//        			dp[i][j]=1;
//        			continue;
//        		}
//        		if(l==2){
//        			if(p.charAt(j)-p.charAt(i)==1)
//        				dp[i][j]=3;
//        			if(p.charAt(i)=='z'&&p.charAt(j)=='a')
//        				dp[i][j]=3;
//        			continue;
//        		}
//        		
//        		if(p.charAt(i+1)-p.charAt(i) == 1)
//    				dp[i][j]=dp[i+1][j];
//    			if(p.charAt(i)=='z' && p.charAt(i+1)=='a')
//    				dp[i][j]+=dp[i+1][j];
//    			
//    			if(p.charAt(j)-p.charAt(j-1) == 1)
//    				dp[i][j]+=dp[i][j-1];
//    			if(p.charAt(j)=='a' && p.charAt(j-1)=='z')
//    				dp[i][j]+=dp[i][j-1];
////        		if(i>0){
////        			if(p.charAt(i+1)-p.charAt(i) == 1)
////        				dp[i][i+l-1]+=dp[i+1][i+l-1];
////        			if(p.charAt(i)=='z' && p.charAt(i+1)=='a')
////        				dp[i][i+l-1]+=dp[i+1][i+l-1];
////        		}
////        		if(i+l-1<len-1){
////        			if(p.charAt(i+l-1)-p.charAt(i+l-2) == 1)
////        				dp[i][i+l-1]+=dp[i][i+l-2];
////        			if(p.charAt(i+l-1)=='a' && p.charAt(i+l-2)=='z')
////        				dp[i][i+l-1]+=dp[i][i+l-2];
////        		}
//        	}
//        }
//    	
//    	return dp[len-1][len-1];
//    }
	

}
