/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
package array;

public class Rotate_Image {

    public void rotate(int[][] matrix) {
        /*旋转处理分两步：1.行元素交换  2.对称交换
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
         */
    	int rows=matrix.length;
    	int cols=matrix[0].length;
    	int temp;
    	//行交换
    	for(int i=0;i<rows/2;i++){
    		for(int j=0;j<cols;j++){
    			temp = matrix[cols-1-i][j];
    			matrix[cols-1-i][j]=matrix[i][j];
    			matrix[i][j]=temp;
    		}
    	}
    	//对称交换
    	for(int i=0;i<rows;i++){
    		for(int j=i;j<cols;j++){
    			temp=matrix[j][i];
    			matrix[j][i]=matrix[i][j];
    			matrix[i][j]=temp;
    		}
    	}
    }
	public static void main(String[] args) {
		Rotate_Image image = new Rotate_Image();
		int[][]m={{1,2,3},{4,5,6},{7,8,9}};
		image.rotate(m);
	}

}
