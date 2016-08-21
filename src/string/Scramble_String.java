package string;

public class Scramble_String {
	public boolean isScramble2(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		if(s1.equals(s2))
			return true;
		int len  = s1.length();
	    boolean dp[][][] = new boolean [len][len][len+1];
		for(int k=1;k<=len;k++){
			for(int i=0;i+k<=len;i++){
				for(int j=0;j+k<=len;j++){
					if(k==1){
						if(s1.charAt(i)==s2.charAt(j))
							dp[i][j][k]=true;
						else
							dp[i][j][k]=false;
					}else{
						for(int x = 1;x<k&& !dp[i][j][k];x++){
							dp[i][j][k]=(dp[i][j][x]&&dp[i+x][j+x][k-x])||(dp[i][j+k-x][x]&&dp[i+x][j][k-x]);
						}
					}
				}
			}
		}
		return dp[0][0][len];
	}
	public boolean isScramble(String s1, String s2) {
	    int len1 = s1.length(), len2 = s2.length();
	    if (len1 != len2) return false;
	    if (len1 == 0) return true;
	    // pruning 
	    if (s1.equals(s2)) return true;
	    int[] count = new int[256];
	    for (int i = 0; i < len1; i++){
	        count[s1.charAt(i)]++;
	        count[s2.charAt(i)]--;
	    }
	    for (int i = 0; i < len1; i++){
	        if (count[s1.charAt(i)] != 0) return false;
	    }
	    for (int i = 1; i < len1; i++){
	        if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
	            return true;
	        if (isScramble(s1.substring(0, i), s2.substring(len1 - i)) && isScramble(s1.substring(i), s2.substring(0, len1 - i)))
	            return true;
	    }
	    return false;
	}
	public static void main(String[] args) {
		System.out.println(new Scramble_String().isScramble("abc", "acb"));
	}
}
