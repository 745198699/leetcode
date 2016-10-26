/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

package tree;
import java.util.*;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1, 1);
    	//dp[i] 表示长度i有的种数
    	int [] dp = new int [n+1];
    	dp[0]=1;dp[1]=1;
        for(int len=2;len<=n;len++){
        	for(int j=1;j<=len;j++){
        		dp[len]+=dp[j-1]*dp[len-j];
        	}
        }
        
        return dp[n];
    }
}
