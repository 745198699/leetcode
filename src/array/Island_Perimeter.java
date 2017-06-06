package array;

public class Island_Perimeter {
	public int islandPerimeter(int[][] grid) {
        
        int x = grid.length;
        int y = grid[0].length;
        
        int count = 0;
        //up
        for(int j=0;j<y;j++){
        	for(int i=0;i<x;i++){
        		if(grid[i][j]==1){
        			if(i==0||grid[i-1][j]==0)
        				count++;
        		}
        	}
        }
        
        //down
        for(int j=0;j<y;j++){
        	for(int i=x-1;i>=0;i--){
        		if(grid[i][j]==1){
        			if(i==x-1||grid[i+1][j]==0)
        				count++;
        		}
        	}
        }
        
        //left
        for(int i=0;i<x;i++){
        	for(int j=0;j<y;j++){
        		if(grid[i][j]==1){
        			if(j==0||grid[i][j-1]==0)
        				count++;
        		}
        	}
        }
        
        //right
        for(int i=0;i<x;i++){
        	for(int j=y-1;j>=0;j--){
        		if(grid[i][j]==1){
        			if(j==y-1||grid[i][j+1]==0)
        				count++;
        		}
        	}
        }
        
        
        
        
        return count;
    
    }
}
