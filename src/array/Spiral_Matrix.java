package array;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

public class Spiral_Matrix {
	
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if(matrix.length==0)
        	return result;
        
        dfs(matrix,result);
        
        return result;
    }
    
    private void dfs(int [][]nums,List <Integer> list){

    	int row = nums.length;int col = nums[0].length;
    
    	//遍历外圈
    	for(int i=0;i<col;i++)
    		list.add(nums[0][i]);
    	for(int i=1;i<row;i++)
    		list.add(nums[i][col-1]);
    	//考虑特殊情况，仅有一行或者一列
    	if(row==1||col==1)
    		return;
    	for(int i=col-2;i>=0;i--)
    		list.add(nums[row-1][i]);
    	for(int i=row-2;i>0;i--){
    		list.add(nums[i][0]);
    	}
    	
    	//取内圈，递归
    	if(row-2<=0||col-2<=0)
    		return;
    	int[][]sub = new int[row-2][col-2];
    	for(int i=0;i<row-2;i++){
    		for(int j=0;j<col-2;j++){
    			sub[i][j]=nums[i+1][j+1];
    		}
    	}

    	dfs(sub,list);
    }
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
	}

}
