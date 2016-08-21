package array;

public class Spiral_Matrix_II {
	
	
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        if(n==0)
        	return result;
        int count =1;
        int top=0;int button=n-1;int right=n-1;int left=0;
        while(count<=n*n){
        	
        	for(int i=left;i<=right;i++,count++){
        		result[top][i]=count;
        	}
        	top++;
        		
        	for(int i=top;i<=button;i++,count++)
        		result[i][right]=count;
        	right--;
        	
        	for(int i=right;i>=left;i--,count++)
        		result[button][i]=count;
        	button--;
        	
        	for(int i=button;i>=top;i--,count++)
        		result[i][left]=count;
        	left++;
        }
        
        return result;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral_Matrix_II ii = new Spiral_Matrix_II();
		ii.generateMatrix(4);
		
	}

}
