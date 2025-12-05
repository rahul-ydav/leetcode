import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Jan31 {
    int[][] grid;
    public int largestIsland(int[][] grid) {

        this.grid = grid;
        int n = grid.length;
        int islandId = 2;
        ArrayList<Integer> islandSizeMp = new ArrayList<>();
        islandSizeMp.add(0);
        islandSizeMp.add(0);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int totalNodes= dfs(i, j, islandId);
                    islandSizeMp.add(totalNodes);
                    islandId++;
                }
            }
        }
        boolean hasZero = false;
        int maxSumPossible = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    hasZero = true;
                    int leftId = (j>0) ? grid[i][j-1] : 0;
                    int rightId = (j<n-1) ? grid[i][j+1] : 0;
                    int topId = (i>0) ? grid[i-1][j] : 0;
                    int bottomId = (i<n-1) ? grid[i+1][j] : 0;

                    HashSet<Integer> uniqueIds = new HashSet<>();
                    uniqueIds.add(leftId);
                    uniqueIds.add(rightId);
                    uniqueIds.add(topId);
                    uniqueIds.add(bottomId);
                    int sum = 1;
                    for(int id : uniqueIds){
                        sum += islandSizeMp.get(id);
                    }
                    maxSumPossible = Math.max(maxSumPossible, sum);
                }
            }
        }

        if(!hasZero) maxSumPossible = n*n;

        return maxSumPossible;
    }

    int dfs(int x, int y, int islandId){
        int[] dir = {-1, 1};
        grid[x][y] = islandId;
        int nodeCount = 1;

        for(int i=0; i<dir.length; i++){
            if(validNode(x, y+dir[i])){
                nodeCount+=dfs(x, y+dir[i], islandId);
            }
            if(validNode(x+dir[i], y)){
                nodeCount+=dfs(x+dir[i], y, islandId);
            }
        }
        return nodeCount;
    }

    boolean validNode(int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1;
    }

}
