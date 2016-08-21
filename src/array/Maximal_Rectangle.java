/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
package array;

public class Maximal_Rectangle {

	public static void main(String[] args) {
		char [][]matrix = new char[][]{
			"110101".toCharArray(),
			"010011".toCharArray(),
			"111101".toCharArray(),
			"111101".toCharArray()};
			int i = new Maximal_Rectangle().maximalRectangle(matrix);
			System.out.println(i);
	}

	public int maximalRectangle(char[][] matrix) {        
	    if(matrix.length==0||matrix==null) return 0;
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int []left = new int[n];
	    int []right = new int[n];
	    int []height = new int[n];
	    int maxA = 0;
	    //init right array
	    for(int i=0;i<n;i++){
	    	right[i]=n;
	    }
	    for(int i=0; i<m; i++) {
	        int cur_left=0, cur_right=n; 
	        for(int j=0; j<n; j++) { // compute height (can do this from either side)
	            if(matrix[i][j]=='1') height[j]++; 
	            else height[j]=0;
	        }
	        for(int j=0; j<n; j++) { // compute left (from left to right)
	            if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
	            else {left[j]=0; cur_left=j+1;}
	        }
	        // compute right (from right to left)
	        for(int j=n-1; j>=0; j--) {
	            if(matrix[i][j]=='1') right[j]=Math.min(right[j],cur_right);
	            else {right[j]=n; cur_right=j;}    
	        }
	        // compute the area of rectangle (can do this from either side)
	        for(int j=0; j<n; j++)
	            maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
	    }
	    return maxA;
	}
}
