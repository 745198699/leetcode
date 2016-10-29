package tree;

public class Morris_Traversal {
	
	public void morris_traversal_inorder(TreeNode root){
		TreeNode cur = root;
		TreeNode prev = null;
		while(cur!=null){
			if(cur.left!=null){
				//find the prev
				prev = cur.left;
				while(prev.right!=null&&prev.right!=cur){
					prev = prev.right;
				}
				if(prev.right==null){
					//connect the end of right to root
					prev.right = cur;
					cur = cur.left;
				}else{
					//disconnect
					prev.right = null;
					System.out.println(cur.val);
					cur = cur.right;
				}
				
			}else{
				//is the left end . print!
				System.out.println(cur.val);
				cur = cur.right;
			}
		}
	}
	
	public void morris_traversal_preorder(TreeNode root){
		TreeNode cur = root;
		TreeNode prev = null;
		
		while(cur!=null){
			
			if(cur.left==null){
				//access the end of left
				System.out.println(cur.val);
				//return to the root by the connection
				cur = cur.right;
				
			}else{
				prev = cur.left;
				while(prev.right!=null&&prev.right!=cur){
					prev = prev.right;
				}
				
				if(prev.right==null){
					System.out.println(cur.val);
					prev.right = cur;
					cur = cur.left;
				}else{
					prev.right = null;
					cur = cur.right;
				}
			}
		}
	}
	
	public void morris_traversal_postorder(TreeNode root){
		TreeNode dump = new TreeNode(-1);
		dump.left = root;
		TreeNode cur = dump;
		TreeNode prev = null;
		while(cur!=null){
			if(cur.left!=null){
				prev = cur.left;
				while(prev.right!=null&&prev.right!=cur){
					prev = prev.right;
				}
				if(prev.right==null){
					//set up connection to root
					prev.right = cur;
					cur = cur.left;
				}
				if(prev.right == cur){
					//jump back from connection
					reversePrint(cur.left, prev);
					prev.right=null;
					cur = cur.right;
				}
				
			}else{
				//jump from connection
				cur = cur.right;
			}
		}
		
		
	}
	
	public void reversePrint(TreeNode from, TreeNode to){
		reverse(from, to);
		
		TreeNode node = to;
		while(true){
			System.out.println(node.val);
			if(node == from)
				break;
			node = node.right;
		}
		
		reverse(to, from);
	}
	
	public void reverse(TreeNode from, TreeNode to){
		if (from == to)
			return;
		TreeNode x = from;
		TreeNode y = from.right;
		TreeNode z = y.right;
		while(true){
			y.right = x;
			x=y;
			y=z;
			z=y.right;
			if(x==to)
				break;
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		new Morris_Traversal().morris_traversal_postorder(root);
	}

}
