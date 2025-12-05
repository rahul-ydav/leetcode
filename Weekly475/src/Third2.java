public class Third2 {
    int ans  = 0;
    int n = 0;
    int m = 0;

    public int maxPathScore(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        finder(grid, 0, 0, k, 0);
        return ans;
    }

    public void finder(int[][] grid, int x, int y, int k, int sum){

        if(x>= n || y>=m || (k==0 && grid[x][y]>0)) return;
        sum += grid[x][y];

        if(x==n-1 && y==m-1){
            ans = Math.max(ans, sum);
        }
        if(grid[x][y]!=0){
            k--;
        }
        finder(grid, x+1, y, k, sum);
        finder(grid, x, y+1, k, sum);
    }
}
