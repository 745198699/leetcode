package array;
import java.util.*;
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        getResult(results,cur, candidates, 0, target);
        return results;
    }
    private void getResult(List<List<Integer>> results, List<Integer> cur,int[]candidates,int start,int target){
    	if(target==0){
    		results.add(new ArrayList<>(cur));
    		return;
    	}
    	for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
    		//过滤重复的结果！i>start这个判断很关键
    		if(i>=1&&candidates[i]==candidates[i-1]&&i>start) continue;
    		cur.add(candidates[i]);
    		getResult(results, cur, candidates, i+1, target-candidates[i]);
    		cur.remove(cur.size()-1);
    	}
    }
}
