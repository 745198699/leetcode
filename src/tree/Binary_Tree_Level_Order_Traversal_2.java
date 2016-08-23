package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_2 {
	
    public List<List<Integer>> levelOrderBottom_BFS(TreeNode root) {
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
			results.add(0,list);
		}
	    return results;
	
    }
    public List<List<Integer>> levelOrderBottom_DFS(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root==null){
			return results;
		}
		level(root,results,1);
		
	    return results;
	}
	
	private void level(TreeNode root, List<List<Integer>> results,int level){
		if(results.size()<level){
			results.add(0,new ArrayList<Integer>());
		}
		results.get(results.size()-level).add(root.val);
		if(root.left!=null)
			level(root.left,results,level+1);
		if(root.right!=null)
			level(root.right,results,level+1);
	}
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(new Binary_Tree_Level_Order_Traversal_2().levelOrderBottom_DFS(root));
	
	}

}
