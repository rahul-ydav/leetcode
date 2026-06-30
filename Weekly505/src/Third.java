import java.util.Arrays;

class Third {
    int[] nums;
    int l;
    int r;
    long dp[][];
    int n;
    long mn = Long.MIN_VALUE/4;
    int om;
    long[] pf;

    public long maximumSum(int[] nums, int m, int l, int r) {
        this.nums = nums;
        this.l = l;
        this.r = r;
        n = nums.length;
        om = m;
        pf = new long[n+1];

        dp = new long[n][m+1];
        for(long[] d1 : dp){
            Arrays.fill(d1, mn);
        }

        for(int i=0; i<n; i++){
            pf[i+1] = pf[i]+nums[i];
        }

        long res = finder(0, m);

        return res;

    }

    long finder(int idx, int m){

        if(idx==n && m==om){
            return mn;
        }
        if(idx==n || m==0){
            return 0;
        }

        if(dp[idx][m]!=mn){
            return dp[idx][m];
        }
        long res = mn;
        res = Math.max(res, finder(idx+1, m));
        // long sum = 0;
        for(int i=idx+l; i<Math.min(idx+r+1, n); i++){
            // sum+=nums[i];
            // if(i-idx+1>=l && i-idx+1<=r){
            // }
            long sum = pf[i+1] - pf[idx];
            res = Math.max(res, sum + finder(i+1, m-1));
        }

        return dp[idx][m] = res;
    }
}