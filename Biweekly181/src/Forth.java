import java.util.Arrays;

class Forth {
    int[] nums;
    int k;
    long[][][] dp;
    public long maxAlternatingSum(int[] nm, int k) {
        int n = nm.length;
        // this.nums = nm;
        this.k = k;

        nums = new int[n+1];
        nums[0] = -1;

        for(int i=1; i<=n; i++){
            nums[i] = nm[i-1];
        }

        dp = new long[2][n+1][n+1];

        for(long[][] d1 : dp){
            for(long[] d2 : d1){
                Arrays.fill(d2, -1);
            }
        }

        long res1 = finder(1, 1, 0);
        nums[0] = 1000_000;
        long res2 = finder(1, 0, 0);

        return Math.max(res1, res2);
    }

    long finder(int idx, int up, int ls){

        if(idx>=nums.length){
            return 0;
        }

        if(dp[up][idx][ls]!=-1) return dp[up][idx][ls];
        long res = 0;
        if(up==1){
            if(nums[idx]>nums[ls]){
                long r1 = Math.max(finder(idx+k, 0, idx), finder(idx+1, 1, ls));
            }
            else{
                res = nums[idx] + finder(idx+1, 1, ls);
            }
        }
        else{
            if(nums[idx]<nums[ls]){
                long r1 = Math.max(finder(idx+k, 1, idx), finder(idx+1, 0, ls));
                res = nums[idx] + r1;
            }
            else{
                res = nums[idx] + finder(idx+1, 0, ls);
            }
        }

        return dp[up][idx][ls] = res;
    }
}