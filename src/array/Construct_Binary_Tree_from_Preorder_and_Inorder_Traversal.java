package array;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public int [] preorder;
	public Map<Integer,Integer> inorderMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		if(preorder==null||preorder.length==0)
			return null;
		for(int i=0;i<inorder.length;i++)
			inorderMap.put(inorder[i], i);

		TreeNode root = new TreeNode(preorder[0]);
		divideInorder(preorder[0], 0, root ,0,inorder.length-1);
		return root;
	}

	private void divideInorder(int rootInt,int rootIntIndex,TreeNode root,int left,int right){
		int i = inorderMap.get(rootInt);
		if(i>left){
			int leftRootInt = preorder[rootIntIndex+1];
			TreeNode leftNode = new TreeNode(leftRootInt);
			root.left=leftNode;
			if(left+1<i){
				//存在left子树
				divideInorder(leftRootInt,rootIntIndex+1,leftNode,left,i-1);
			}
		}
		if(i<right){
			int rightRootInt = preorder[rootIntIndex+i-left+1];
			TreeNode rightNode = new TreeNode(rightRootInt);
			root.right=rightNode;
			if(i+1<right){
				//存在right子树
				divideInorder(rightRootInt, rootIntIndex+i-left+1, rightNode, i+1, right);
			}
		}



	}

	public static void main(String[] args) {
		new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal().buildTree(new int[]{1,2,3}, new int[]{1,2,3});
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}