package array;

public class Unique_Paths_II {
	
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] a = new int [obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
        	for(int j=0;j<obstacleGrid[0].length;j++){
        		if(obstacleGrid[i][j]==0){
        			a[i][j]=0;
        		}else if(obstacleGrid[i][j]==1){
        			a[i][j]=-1;
        		}
        	}
        }
        
        //dp init
        for(int i=0;i<a.length;i++){
        	if(a[i][0]!=-1){
        		a[i][0]=1;
        	}else
        		break;
        }
        for(int i=0;i<a[0].length;i++){
        	if(a[0][i]!=-1){
        		a[0][i]=1;
        	}else
           		break;
        }
        
        //start dp
        for(int i=1;i<a.length;i++){
        	for(int j=1;j<a[0].length;j++){
        		if(a[i][j]==-1)
        			continue;
        		if(a[i-1][j]!=-1){
        			a[i][j]+=a[i-1][j];
        		}
        		if(a[i][j-1]!=-1){
        			a[i][j]+=a[i][j-1];
        		}
        	}
        }
		
        if(a[a.length-1][a[0].length-1]==-1)
        	return 0;
		
		return a[a.length-1][a[0].length-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unique_Paths_II ii = new Unique_Paths_II();
		int [][] a = {{0,0,0},{0,0,0},{0,0,1}};
//		int[][]a = {{1,0}};
		
		System.out.println(ii.uniquePathsWithObstacles(a));
	}

}
