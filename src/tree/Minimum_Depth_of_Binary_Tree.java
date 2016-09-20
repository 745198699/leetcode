package tree;
import java.util.*;
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        int level = 0;
        if(root == null)
        	return level;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	level++;
        	int len = queue.size();
        	for(int i=0;i<len;i++){
        		TreeNode pop = queue.poll();
        		if(pop.left==null&&pop.right==null)
        			return level;
        		if(pop.left!=null)
        			queue.offer(pop.left);
        		if(pop.right!=null)
        			queue.offer(pop.right);
        	}
        }
    	
    	return 0;
    }

	public static void main(String[] args) {

	}

}
