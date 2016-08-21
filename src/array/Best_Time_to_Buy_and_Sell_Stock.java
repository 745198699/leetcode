package array;

public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length==0)
			return 0;
	    int max =0;
	    int lowestP = prices[0];
	    for(int i=1;i<prices.length;i++){
	    	if(prices[i]>lowestP){
	    		if(max<prices[i]-lowestP)
	    			max=prices[i]-lowestP;
	    	}
	    	else
	    		lowestP=prices[i];
	    }
		
		return max;
	}
    public static void main(String[] args) {
		int i=new Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[]{2,1,4});
		System.out.println(i);
	}
}
