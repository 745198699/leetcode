package array;
import java.util.*;
public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		getResult(results,new ArrayList<Integer>(),candidates,0,target);

		return results;
	}
	private void getResult(List<List<Integer>> results,List<Integer>cur,int[]candidates,int start,int targer){
		if(targer>0){
			for(int i=start;i<candidates.length&&candidates[i]<=targer;i++){
				cur.add(candidates[i]);
				getResult(results, cur, candidates, i, targer-candidates[i]);
				cur.remove(cur.size()-1);}
		}else if(targer==0){
			results.add(new ArrayList<Integer>(cur));
		}

	}
}
