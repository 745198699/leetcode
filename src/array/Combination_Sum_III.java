package array;
import java.util.*;
public class Combination_Sum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer>cur = new ArrayList<Integer>();
		getResult(results, cur, 1, n,k);

		return results;
	}

	private void getResult(List<List<Integer>> results,List<Integer>cur,int start,int n,int k){
		if(n==0&&cur.size()==k){
			results.add(new ArrayList<Integer>(cur));
		}else if(n>0&&cur.size()<k){
			for(int i=start;i<=9;i++){
				cur.add(i);
				getResult(results, cur, i+1, n-i, k);
				cur.remove(cur.size()-1);
			}
		}
	}
}
