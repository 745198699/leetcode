package array;

public class Best_Time_to_Buy_and_Sell_Stock_III {
//    public int maxProfit(int[] prices) {
//        if(prices==null||prices.length==0)
//        	return 0;
//        int [] MaxTwo = new int[]{0,0};//要求max[0]>=max[1]
//        int curMax = 0;
//        for(int i=1;i<prices.length;i++){
//        	if(prices[i]>prices[i-1]){
//        		curMax+=prices[i]-prices[i-1];
//        	}else if(prices[i]<prices[i-1]){
//        		if(curMax>MaxTwo[0]){
//        			MaxTwo[1]=MaxTwo[0];
//        			MaxTwo[0]=curMax;
//        		}
//        		else if(curMax>=MaxTwo[1])
//        			MaxTwo[1]=curMax;
//        		
//        		curMax=0;
//        	}
//        }
//        if(curMax>MaxTwo[0]){
//        	MaxTwo[1]=MaxTwo[0];
//			MaxTwo[0]=curMax;
//		}
//		else if(curMax>=MaxTwo[1])
//			MaxTwo[1]=curMax;
//        return MaxTwo[0]+MaxTwo[1];
//    }
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    public static void main(String[] args) {
		new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit(new int[]{1,2,3,4,5,1,2});
	}
}
