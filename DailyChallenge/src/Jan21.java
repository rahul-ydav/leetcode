public class Jan21 {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] sum1 = new long[n];
        long[] sum2 = new long[n];
        sum1[0] = grid[0][0];
        sum2[n-1] = grid[1][n-1];
        for(int i=1; i<n; i++){
            sum1[i] = sum1[i-1] + (long)grid[0][i];
        }
        for(int i=n-2; i>=0; i--){
            sum2[i] = sum2[i+1] + (long)grid[1][i];
        }
        int maxIdx = 0;
        for(int i=0; i<n; i++){
            if(sum1[i]+sum2[i]>sum1[maxIdx]+sum2[maxIdx]){
                maxIdx=i;
            }
        }

        long ans = Math.max(sum1[n-1]-sum1[maxIdx], sum2[0]-sum2[maxIdx]);

        return ans;
    }
}
