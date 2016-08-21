package string;

public class Distinct_Subsequences {
	public int numDistinct(String s, String t) {
		if(t.length()>s.length())
			return 0;
		if(s.equals(t))
			return 1;

		//dp[i][j]表示s前i个 和 t前j个 匹配上的个数
		int dp[][] = new int [s.length()+1][t.length()+1];

		//init dp[][]
		for(int i=0;i<=s.length();i++)
			dp[i][0]=1;

		//start dp
		for(int j=0; j<t.length(); j++){
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)==t.charAt(j))
					dp[i+1][j+1]=dp[i][j]+dp[i][j+1];
				else
					dp[i+1][j+1]=dp[i][j+1];

			}
		}

		return dp[s.length()][t.length()];
	}

	 public int numDistinct2(String s, String t) {
         // arr works as a hash table
         int[][] arr = new int[256][t.length()+1];
         int[] cnt = new int[t.length()+1];
         cnt[0] = 1;
         char c;
         for(int i = 0; i < t.length(); i++ ) {
             // arr[c] is a list of all the positions character c appears
             // arr[c][0] records how many times character c appears
             c = t.charAt(i);
             arr[c][arr[c][0]+1] = i+1;
             arr[c][0]++;
         }
         // DP
         for( char a: s.toCharArray() ) {
             if( arr[a][0] != 0 ) {
                 for( int i = arr[a][0]; i > 0; i-- ) {
                     cnt[arr[a][i]] += cnt[arr[a][i]-1];
                 }
             }
         }
         return cnt[t.length()];
     }
	
	public static void main(String[] args) {
		System.out.println(new Distinct_Subsequences().numDistinct2("rabbbit", "rabbit"));
	}
}
