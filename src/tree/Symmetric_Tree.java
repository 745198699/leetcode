package tree;

import java.util.*;

public class Symmetric_Tree {
	
    public boolean isSymmetric(TreeNode root) {
    	return root==null || isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
    	if(left==null||right==null)
    		return left==right;
    	if(left.val!=right.val)
    		return false;
    	return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    	
    }
//    public boolean isSymmetric(TreeNode root) {
//     
//    	if(root == null)
//    		return true;
//    	
//    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
//    	queue.offer(root);
//    	
//    	while(!queue.isEmpty()){
//    		int size = queue.size();
//    		List<TreeNode> list = new ArrayList<TreeNode>();
//    		for(int i=0;i<size;i++){
//    			TreeNode cur = queue.poll();
//    			if(cur.left!=null){
//    				queue.offer(cur.left);
//    				list.add(cur.left);
//    			}else{
//    				list.add(null);
//    			}
//    			
//    			if(cur.right!=null){
//    				queue.offer(cur.right);
//    				list.add(cur.right);
//    			}else{
//    				list.add(null);
//    			}
//    		}
//    		if(!isPalin(list))
//    			return false;
//    	}
//    	
//    	return true;
//    }
//    
//    private boolean isPalin(List<TreeNode> list){
//    	int start =0;
//    	int end = list.size()-1;
//    	while(start<end){
//    		TreeNode left = list.get(start);
//    		TreeNode right = list.get(end);
////    		if(left!=null&&right!=null&&left.val!=right.val)
////    			return false;
//    		if(left==null&&right!=null||left!=null&&right==null)
//    			return false;
//    		if(left!=null&&right!=null&&left.val!=right.val)
//    			return false;
//    		start++;
//    		end--;
//    	}
//    	
//    	
//    	return true;
//    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);root.left.right.left=new TreeNode(4);
		root.right.left = new TreeNode(3);root.right.left.right = new TreeNode(4);
		System.out.println(new Symmetric_Tree().isSymmetric(root));
	}

}
