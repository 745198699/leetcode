package tree;
import java.util.*;

public class Unique_Binary_Search_Trees_II {
	public List<TreeNode> generateTrees(int n) {

		List<TreeNode> res = new ArrayList<>();
		if(n==0)
			return res;
		List<TreeNode>[] map = new List[n+1];
		List<TreeNode> list0 = new ArrayList<>();
		list0.add(null);
		map[0]= list0;
		// 		List<TreeNode> list = new ArrayList<>();
		// 		list.add(new TreeNode(1));
		// 		map[1] = list;
		for(int len = 1;len<=n;len++){
			List<TreeNode> init = new ArrayList<>();
			map[len] = init;
			for(int root_value = 1; root_value<=len; root_value++){
				List<TreeNode>left_list = map[root_value-1];
				List<TreeNode>right_list = new ArrayList<>();
				for(TreeNode right : map[len-root_value]){
					right_list.add(plus(right, root_value));
				}
				for(TreeNode leftsub : left_list){
					for(TreeNode rightsub:right_list){
						TreeNode root = new TreeNode(root_value);
						root.left = leftsub;
						root.right = rightsub;
						map[len].add(root);
					}
				}
			}
		}
		return map[n];
	}

	public TreeNode plus(TreeNode root, int i){
		if(root == null)
			return null;
		TreeNode new_root = new TreeNode(root.val+i);
		new_root.left = plus(root.left,i);
		new_root.right = plus(root.right,i);
		return new_root;
	}

}
