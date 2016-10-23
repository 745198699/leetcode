/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
package tree;

import java.util.*;

public class Binary_Tree_Right_Side_View {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int queueLen = queue.size();
			for(int i=0;i<queueLen;i++){
				TreeNode curNode = queue.poll();
				if(i==queueLen-1)
					res.add(curNode.val);
				if(curNode.left!=null)
					queue.offer(curNode.left);
				if(curNode.right!=null)
					queue.offer(curNode.right);
			}
		}

		return res;
	}

	//dfs 要比上面的bfs快。
	//dfs的时候，递归是先递归右子树，向结果集合中添加当前层的第一个元素

	public List<Integer> rightSideView_DFS(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(res, root, 0);
		
		return res;
	}
	
	public void dfs(List<Integer> res, TreeNode root, int curDepth){
		if(root==null)
			return;
		if(curDepth == res.size())
			res.add(root.val);
		
		dfs(res, root.right, curDepth+1);
		dfs(res, root.left, curDepth+1);
	}
}
