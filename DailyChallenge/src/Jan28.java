import java.util.ArrayList;
import java.util.HashMap;

public class Jan28 {
    int[][] grid;
    int maxSum = 0;
    int sum = 0;
    public int findMaxFish(int[][] g) {
        grid = g;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    sum = 0;
                    bfs(i, j);
                }
            }
        }
        return maxSum;
    }

    void bfs(int x, int y){
        sum+=grid[x][y];
        maxSum = Math.max(maxSum, sum);
        grid[x][y] = 0;

        int[] dx = {-1, 1};
        int[] dy = {-1, 1};

        for(int i=0; i<dx.length; i++) {
            if (validNode(x + dx[i], y)) {
                bfs(x + dx[i], y);
            }
        }
        for(int j=0; j<dy.length; j++){
            if(validNode(x, y+dy[j])){
                bfs(x, y+dy[j]);
            }
        }
    }

    boolean validNode(int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]>0;
    }
}
