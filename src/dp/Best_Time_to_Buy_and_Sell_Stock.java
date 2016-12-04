package dp;

public class Best_Time_to_Buy_and_Sell_Stock {
	
	public int maxProfit(int[] prices) { 
		int max_profit = 0;
		int cur_min = Integer.MAX_VALUE;
		for(int i:prices){
			if(i<cur_min)
				cur_min=i;
			if(i-cur_min>max_profit)
				max_profit=i-cur_min;
		}
		
		return max_profit;
	}

	public static void main(String[] args) {

	}

}
