/**
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 */
package dp;

public class Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
    	//dp[i][j]表示，从i到j，保证完成的最优解
        int dp[][] = new int[n+1][n+1];
        
        return f(dp,1,n);
        
    }
    
    private int f(int dp[][], int i, int j){
    	if(dp[i][j]!=0)
    		return dp[i][j];
    	if(i<=j)
    		return 0;
    	int min=Integer.MAX_VALUE;
    	for(int index=i;index<=j;index++){
    		int temp = index+f(dp,i,index-1)+f(dp,index+1,j);
    		min = Math.min(temp, min);
    	}
    	dp[i][j]=min;
    	return min;
    }
    
    public static void main(String[] args) {
		System.out.println(new Guess_Number_Higher_or_Lower_II().getMoneyAmount(2));
	}
}
