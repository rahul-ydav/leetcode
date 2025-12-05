class Second {

    long[][] memo;
    int m;
    int n;
    int[][] waitCost;
    public long minCost(int m, int n, int[][] waitCost) {

        memo = new long[m+1][n+1];

        this.m =m;
        this.n = n;
        this.waitCost = waitCost;

        return finder(0, 0);

    }

    long finder(int i, int j){

        long res =(long)(i+1)*(j+1);
        if(i==m-1 && j==n-1){
            return res;
        }

        if(memo[i][j]!=0) return memo[i][j];

        if(i!=0 || j!=0) res+=(long)waitCost[i][j];
        long ans = 0;
        if(i+1<m && j+1<n){
            ans = Math.min(finder(i+1, j), finder(i, j+1));
        }
        else if(i+1<m){
            ans = finder(i+1, j);
        }
        else{
            ans = finder(i, j+1);
        }

        ans = ans +res;

        memo[i][j] = ans;
        return ans;
    }
}