package string;

public class Interleaving_String {
	public boolean isInterleave(String s1, String s2, String s3) {
	    int len1 = s1.length();
	    int len2 = s2.length();
	    int len3 = s3.length();
	    if(len1+len2!=len3)
	    	return false;
	    
	    //dp的含义：dp[i][j]表示，s1的前i个字符，s2前j个字符，可以组成s3前i+j个字符
	    boolean dp[][] = new boolean [len1+1][len2+1];
	    //init
	    dp[0][0]=true;
	    for(int i=1;i<=len1;i++)
	    	dp[i][0]=dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
	    for(int j=1;j<=len2;j++)
	    	dp[0][j]=dp[0][j-1]&&(s2.charAt(j-1)==s3.charAt(j-1));
	    for(int i=1;i<=len1;i++){
	    	for(int j=1;j<=len2;j++){
	    		if(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1))){
	    			dp[i][j]=true;
	    			continue;
	    		}
	    		if(dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1))){
	    			dp[i][j]=true;
	    			continue;
	    		}
	    		dp[i][j]=false;
	    	}
	    }
	    
	    return dp[len1][len2];
	}
    
    public static void main(String[] args) {
    	boolean a = new Interleaving_String().isInterleave("", "b", "b");
    	System.out.println(a);
	}
}
