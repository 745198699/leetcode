package tree;
import java.util.*;
public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> re = new ArrayList<String>();
        if(root==null){
    		return re;
    	}
        
        String curPath = root.val+"";
        dfs(root, curPath,re);
    	return re;
    }
    
    private void dfs(TreeNode root,String curPath,List<String> re){
    	if(root.left==null&&root.right==null){
    		re.add(curPath);
    		return;
    	}
    	if(root.left!=null){
    		String tmp = (curPath+"->"+root.left.val);
    		dfs(root.left, tmp, re);
    	}
    	if(root.right!=null){
    		String tmp = (curPath+"->"+root.right.val);
    		dfs(root.right, tmp, re);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.println(new Binary_Tree_Paths().binaryTreePaths(root));
	}

}
