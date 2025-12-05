public class Second {

    int[][][] memo;
    int m = 0;
    int n = 0;

    int finder2(int[][] coins, int x, int y, int rCount){
        if(x==m-1 && y==n-1){
            if(rCount<2){
                return Math.max(coins[x][y], 0);
            }
            return coins[x][y];
        }

        int ans = 0;

        if(memo[x][y][rCount]!=Integer.MIN_VALUE)   return memo[x][y][rCount];

        if(x>=m-1){
            if(rCount<2){
                ans = Math.max(finder2(coins, x, y+1, rCount) + coins[x][y], finder2(coins, x, y+1, rCount+1));
            }
            else    ans = finder2(coins, x, y+1, rCount) + coins[x][y];
        }
        else if(y>=n-1){
            if(rCount<2){
                ans = Math.max(finder2(coins, x+1, y, rCount) + coins[x][y], finder2(coins, x+1, y, rCount+1));
            }
            else    ans = finder2(coins, x+1, y, rCount) + coins[x][y];
        }
        else {
            if (rCount < 2) {
                int ans1 = coins[x][y] + Math.max(finder2(coins, x + 1, y, rCount), finder2(coins, x, y + 1, rCount));
                int ans2 = Math.max(finder2(coins, x + 1, y, rCount + 1), finder2(coins, x, y + 1, rCount + 1));
                ans = Math.max(ans1, ans2);
            } else ans = coins[x][y] + Math.max(finder2(coins, x + 1, y, rCount), finder2(coins, x, y + 1, rCount));
        }
        memo[x][y][rCount] = ans;
        return ans;
    }


    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        memo = new int[m][n][3];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    memo[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return finder2(coins, 0, 0, 0);
    }
}
