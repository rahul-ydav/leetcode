public class Q2 {

    final int mod = 1000000007;
    int[][] grid;
    int k;
    Integer[][][] memo;

    int findPaths(int i, int j, int xor){
        xor=xor^grid[i][j];
        if(memo[i][j][xor]!=null)    return memo[i][j][xor];
        int ans = 0;
        if(i==grid.length-1 && j==grid[0].length-1){
            if(xor==k){
                return 1;
            }
            return 0;
        }
        if(i+1<grid.length) ans += (findPaths(i+1, j, xor)%mod);
        if(j+1<grid[0].length)  ans += (findPaths(i, j+1, xor)%mod);
        memo[i][j][xor] = ans%mod;
        return memo[i][j][xor];
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.memo = new Integer[grid.length][grid[0].length][17];
        return findPaths(0, 0, 0);
    }
}
