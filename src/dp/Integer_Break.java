package dp;
/**
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
Note: You may assume that n is not less than 2 and not larger than 58.
 * @author yujianbo
 *
 */
public class Integer_Break {
    public int integerBreak(int n) {
        int [] dp = new int[n+1];
        return button2up(dp, n);
    }
    
    private int button2up(int[]dp, int n){
    	dp[1]=1;
    	for(int i=2;i<=n;i++){
    		for(int j=1;j<i;j++){
    			dp[i] =Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j])) ;
    		}
    	}
    	return dp[n];
    }
    
    private int up2button(int[]dp, int n){
    	if(n==1 || n==2)
    		return 1;
    	if(dp[n]!=0)
    		return dp[n];
    	int max = 0;
    	for(int i=1;i<n;i++){
    		int tmp =Math.max(i, up2button(dp,i))*Math.max(n-i, up2button(dp,n-i));
    		if(tmp>max)
    			max=tmp;
    	}
    	dp[n]=max;
    	return dp[n];
    }
    
    

	public static void main(String[] args) {
		System.out.println(new Integer_Break().integerBreak(10));
	}

}
