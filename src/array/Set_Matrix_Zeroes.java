package array;

public class Set_Matrix_Zeroes {	
    public void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
        int [] flag = new int [n+m];
        
        if(n==0||m==0)
        	return;
        
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]==0){
        			flag[i]=1;
        			flag[j+m]=1;
        		}
        	}
        }
        
        for(int i=0;i<m;i++){
        	if(flag[i]==1){
        		for(int j=0;j<n;j++)
        			matrix[i][j]=0;
        	}
        }
        
        for(int i=m;i<m+n;i++){
        	if(flag[i]==1){
        		for(int j=0;j<m;j++)
        			matrix[j][i-m]=0;
        	}
        }        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set_Matrix_Zeroes matrix_Zeroes = new Set_Matrix_Zeroes();
//		int [][]matrix = {{1,2,3},{1,0,3},{1,2,3}};
		int[][]matrix = {{1}};
		matrix_Zeroes.setZeroes(matrix);
	}

}
