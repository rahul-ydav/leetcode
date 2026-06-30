import java.util.Arrays;

class Forth {
    long[][] dp;
    int n;
    int m;
    int d;
    String[] grid;
    long mod = 1_000_000_007;

    public int numberOfRoutes(String[] grid, int d) {
        n = grid.length;
        m = grid[0].length();
        this.grid = grid;
        this.d = d;

        dp = new long[n][m];

        for(long[] dpx : dp){
            Arrays.fill(dpx, -1);
        }

        long res = 0;

        for(int i=0; i<m; i++){
            if(grid[n-1].charAt(i)=='.'){
                res = (res + finder(n-1, i, false))%mod;
            }
        }

        return (int)res;
    }

    long finder(int x, int y, boolean change){

        if(dp[x][y]!=-1)    return dp[x][y];
        long res =0;
        if(x==0){
            int start = Math.max(y-d, 0);
            int end = Math.min(y+d, m-1);
            for(int i=start; i<=end; i++){
                if(grid[x].charAt(i)=='.'){
                    res++;
                }
            }

            return dp[x][y] = res;
        }

        if(!change){
            int start = Math.max(y-d, 0);
            int end = Math.min(y+d, m-1);
            for(int i=start; i<=end; i++){
                if(grid[x].charAt(i)=='.'){
                    res = (res + finder(x, i, !change))%mod;
                }
            }

            return dp[x][y] = res;
        }
        int start = Math.max(y-d+1, 0);
        int end = Math.min(y+d-1, m-1);
        for(int i=start; i<=end; i++){
            if(grid[x].charAt(i)=='.'){
                res = (res + finder(x-1, i, !change))%mod;
            }
        }



        return dp[x][y] = res;
    }
}