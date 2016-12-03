package tree;

public class Serialize_and_Deserialize_BST {
	   public String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        if (root == null) return sb.toString();
	        preorder(root, sb);
	        return sb.substring(0, sb.length() - 1);
	    }
	    private void preorder(TreeNode root, StringBuilder sb) {
	        if (root == null) return;
	        sb.append(root.val).append("#");
	        preorder(root.left, sb);
	        preorder(root.right, sb);
	    }

	    public TreeNode deserialize(String data) {
	        if (data.isEmpty()) return null;
	        String[]arr = data.split("#");
	        return buildTree(arr, 0, arr.length - 1);
	    }
	    private TreeNode buildTree(String[] arr, int l, int r) {
	        if (l > r) return null;
	        TreeNode root = new TreeNode(Integer.parseInt(arr[l]));
	        int splitIndex = findIndex(arr, Integer.parseInt(arr[l]), l + 1, r);
	        root.left = buildTree(arr, l + 1, splitIndex - 1);
	        root.right = buildTree(arr, splitIndex, r);
	        return root;
	    }
	    private int findIndex(String[] arr, int target, int l, int r) {
	        int i = l;
	        for (; i <= r; i++) {
	            if (Integer.parseInt(arr[i]) > target) break;
	        }
	        return i;
	    }
}
