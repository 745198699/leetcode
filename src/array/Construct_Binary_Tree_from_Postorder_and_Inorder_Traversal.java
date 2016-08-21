package array;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Postorder_and_Inorder_Traversal {
	private Map<Integer,Integer>map = new HashMap<Integer,Integer>();
	private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++)
        	map.put(inorder[i],i);
    	this.postorder = postorder;
    	if(inorder==null||inorder.length==0)
    		return null;
    	TreeNode root = new TreeNode(postorder[postorder.length-1]);
    	divideIorder(postorder[postorder.length-1], postorder.length-1, root, 0, postorder.length-1);
    	return root;
    }
    
    private void divideIorder(int rootInt,int rootIndexPost,TreeNode root,int left,int right) {
		int rootIndexIn = map.get(rootInt);
		if(rootIndexIn<right){
			//exist right subTree or rightChild
			int rightRootInt = postorder[rootIndexPost-1];
			TreeNode rightNode = new TreeNode(rightRootInt);
			root.right=rightNode;
			if(rootIndexIn+1<right)
				divideIorder(rightRootInt, rootIndexPost-1, rightNode, rootIndexIn+1, rightRootInt);
		}
		if(rootIndexIn>left){
			int leftRootInt = postorder[rootIndexPost-1-(right-rootIndexIn)];
			TreeNode leftNode = new TreeNode(leftRootInt);
			root.left=leftNode;
			if(rootIndexIn-1>left)
				divideIorder(leftRootInt, rootIndexPost-1-(right-rootIndexIn), leftNode, left, rootIndexIn-1);
		}
	}
    public static void main(String[] args) {
		new Construct_Binary_Tree_from_Postorder_and_Inorder_Traversal().buildTree(new int[]{1,2,3,4}, new int[]{2,1,4,3});
	}
}
