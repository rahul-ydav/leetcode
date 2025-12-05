public class Second2 {
    public long minCost(int m, int n, int[][] waitCost) {

        long[][] res = new long[m+1][n+1];

        for(int i=0; i<=m; i++){
            res[i][0] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=n; i++){
            res[0][i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++ ){
                res[i][j] += (long)i*j;
                if(!((i==1 && j==1) || (i==m && j==n)))    res[i][j] += (long) waitCost[i-1][j-1];
                long ans =  Math.min(res[i-1][j], res[i][j-1]);
                if(ans!=(long)Integer.MAX_VALUE){
                    res[i][j]+=ans;
                }
            }
        }

        return res[m][n];
    }
}
