/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
package array;

public class Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        if(rows==0)
        	return false;
        int lines=matrix[0].length;
        
        //search first element of each row
        int up=0,down=rows-1;
        while(up<=down){
        	int mid = up + ((down-up)>>1);
        	if(matrix[mid][0]==target)
        		return true;
        	if(target<matrix[mid][0])
        		down=mid-1;
        	else
        		up=mid+1;
        }
        if(down==-1)
        	return false;
        //search the row
        int left=0,right=lines-1;
        while(left<=right){
        	int mid = left+((right-left)>>1);
        	if(matrix[down][mid]==target)
        		return true;
        	if(target<matrix[down][mid])
        		right=mid-1;
        	else
        		left=mid+1;
        }
        return false;
    }
    
	public static void main(String[] args) {

		int[][]m={{1}};
		System.out.println(new Search_a_2D_Matrix().searchMatrix(m, 0));
	}

}
