package tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums==null||nums.length==0)
    		return null;
        return recurse(nums, 0, nums.length-1);
    }
    
    public TreeNode recurse(int[] nums,int start, int end){
    	if(start == end-1){
    		TreeNode root = new TreeNode(nums[start]);
    		root.right = new TreeNode(nums[end]);
    		return root;
    	}else if(start == end){
    		return new TreeNode(nums[start]);
    	}
    	int mid = (start+end)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = recurse(nums, start, mid-1);
    	root.right = recurse(nums, mid+1, end);
    	return root;
    }
    
    public static void main(String[] args) {
		new Convert_Sorted_Array_to_Binary_Search_Tree().sortedArrayToBST(new int[]{1,2,3,4,5,6});
	}
}
