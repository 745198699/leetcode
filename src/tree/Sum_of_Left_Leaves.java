package tree;
import java.util.*;
public class Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        	return 0;
        
        int re=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node.left!=null){
        		if(node.left.left==null&&node.left.right==null)
        			re+=node.left.val;
        		else
        			queue.offer(node.left);
        	}
        	if(node.right!=null)
        		queue.offer(node.right);
        }
    	return re;
    }
    
    public int sumRecursive(TreeNode root){
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        if(root.right != null) {
            ans += sumOfLeftLeaves(root.right);
        }
        
        return ans;
    }
}
