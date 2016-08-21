package tree;
import tree.TreeNode;

import java.util.*;


public class Binary_Tree_Level_Order_Traversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root==null){
    		return results;
    	}
    	
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	
    	while(!q.isEmpty()){
    		List<Integer> list = new ArrayList<Integer>();
    		int size = q.size();
    		for(int i=0;i<size;i++){
    			TreeNode curNode = q.poll();
    			list.add(curNode.val);
    			
    			if(curNode.left!=null)
    				q.offer(curNode.left);
    			if(curNode.right!=null)
    				q.offer(curNode.right);
    		}
    		results.add(list);
    	}
    	
        return results;
	}
	
	
	
    public List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root==null){
    		return results;
    	}
    	level(root,results,1);
    	
        return results;
    }
    
    private void level(TreeNode root, List<List<Integer>> results,int level){
    	if(results.size()<level){
    		results.add(new ArrayList<Integer>());
    	}
    	results.get(level-1).add(root.val);
    	if(root.left!=null)
    		level(root.left,results,level+1);
    	if(root.right!=null)
    		level(root.right,results,level+1);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		System.out.println(new Binary_Tree_Level_Order_Traversal().levelOrder(root));
	}

}
