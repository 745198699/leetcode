package array;

public class Best_Time_to_Buy_and_Sell_Stock_II {
	public int maxProfit(int[] prices) {
		int totle=0;
		if(prices.length==0||prices==null)
			return 0;
	    for(int i=1;i<prices.length;i++){
	    	if(prices[i]>prices[i-1])
	    		totle+=(prices[i]-prices[i-1]);
	    }
		return totle;
	}
    
    public static void main(String[] args) {
		new Best_Time_to_Buy_and_Sell_Stock_II().maxProfit(new int[]{});
	}
}
