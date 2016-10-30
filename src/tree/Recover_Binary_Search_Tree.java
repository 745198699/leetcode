package tree;

public class Recover_Binary_Search_Tree {
	
    public void recoverTree(TreeNode root) {
    	TreeNode firstNode = null;
    	TreeNode secondNode = null;
    	TreeNode pre = null;//record the previous node

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
					if(pre!=null && pre.val>cur.val){
						if(firstNode==null){
							firstNode = pre;
							secondNode = cur;
						}else{
							secondNode = cur;
						}
					}
					prev.right = null;
//					System.out.println(cur.val);
					pre = cur;
					cur = cur.right;
				}
				
			}else{
				//is the left end . print!
				if(pre != null && pre.val>cur.val){
					if(firstNode==null){
						firstNode = pre;
						secondNode = cur;
					}else{
						secondNode = cur;
					}
				}
//				System.out.println(cur.val);
				pre = cur;
				cur = cur.right;
			}
		}
		
		System.out.println(firstNode.val);
		System.out.println(secondNode.val);
		//swap first and second
		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
		
	
    }
}
