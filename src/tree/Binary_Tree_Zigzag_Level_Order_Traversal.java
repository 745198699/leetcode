package tree;
import java.util.*;
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root==null)
    		return res;
    	Deque<TreeNode> q = new ArrayDeque<>();
    	int curDepth = 1;
    	q.offer(root);
    	while(!q.isEmpty()){
    		List<Integer> re = new ArrayList<>();
    		int len = q.size();
    		if(curDepth%2==1){
    			//left -> right
    			for(int i=0;i<len;i++){
    				TreeNode node = q.pollFirst();
    				re.add(node.val);
    				if(node.left!=null)
    					q.offerLast(node.left);
    				if(node.right!=null)
    					q.offerLast(node.right);
    			}
    			
    		}else{
    			//right -> left
    			for(int i=0;i<len;i++){
    				TreeNode node = q.pollLast();
    				re.add(node.val);
    				if(node.right!=null)
    					q.offerFirst(node.right);
    				if(node.left!=null)
    					q.offerFirst(node.left);
    			}
    			
    		}
    		res.add(re);
    		curDepth++;
    	}
    	
    	return res;
    }
    
    public List<List<Integer>> zigzagLevelOrder_dfs(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    
    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
