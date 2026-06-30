import java.util.Arrays;

class Lt3742 {
    int m;
    int n;
    int[][] grid;
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        if(k==0){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]!=0){
                        return -1;
                    }
                }
            }
            return 0;
        }

        dp = new int[m+1][n+1][k+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = finder(0, 0, k);

        if(res<0)   return -1;
        return res;

    }

    int finder(int x, int y, int k){


        if(x==m-1 && y==n-1){
            if(k<=0 && grid[x][y]>0){
                return -10000;
            }
            return grid[x][y];
        }
        if(k<=0 && grid[x][y]>0) return -10000;

        if(dp[x][y][k]!=-1){
            return dp[x][y][k];
        }

        int down = -10000;
        if(x+1<m){
            down = (grid[x][y]==0) ? finder(x+1, y, k) : grid[x][y] + finder(x+1, y, k-1);
        }
        int right = -10000;
        if(y+1<n){
            right = (grid[x][y]==0) ? finder(x, y+1, k) : grid[x][y] + finder(x, y+1, k-1);
        }

        int res = Math.max(down, right);

        return dp[x][y][k] = res;

    }
}