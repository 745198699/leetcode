package dp;

public class Counting_Bits {
    public int[] countBits(int num) {
        int count[] = new int[num+1];
        count[0] = 0;
        int cur_2n = 0;
        for(int i=1; i<=num; i++){
        	//如果i是2^n
        	if((i-1&i)==0){
        		cur_2n = i;
        		count[i]=1;
        	}else{
        		count[i]=1+count[i-cur_2n];
        	}
        	
        }
        return count;
    }
    public static void main(String[] args) {
		new Counting_Bits().countBits(16);
	}
}
