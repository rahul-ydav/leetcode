import java.util.Arrays;

class Lt3892 {
    int n;
    int[][] dp;
    public int minOperations(int[] nums, int k) {
        n = nums.length;
        dp = new int[k+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        if(k>n/2)   return -1;
        if(n<3) return 0;

        return finder(nums, k, 0);
    }

    int finder(int[] nums, int k, int i){
        if(k==0){
            return 0;
        }
        if(i>n-1){
            return Integer.MAX_VALUE/4;
        }

        if(dp[k][i]!=-1)    return dp[k][i];


        int curr = 0;
        int curr2 = 0;
        if(i==0){
            curr = Math.max(nums[n-1], nums[i+1]) + 1 - nums[i];
            curr2 = Math.max(nums[i], nums[i+2]) + 1 - nums[i+1];
        }
        else if(i==n-2){
            if(k>1) return Integer.MAX_VALUE/4;
            curr = Math.max(nums[i-1], nums[i+1]) + 1 - nums[i];
            curr2 = Math.max(nums[i], nums[0]) + 1 - nums[i+1];
            if(curr<0)  curr = 0;
            if(curr2<0)  curr2 = 0;
            return Math.min(curr, curr2);
        }
        else if(i==n-1){
            curr = Math.max(nums[i-1], nums[0]) + 1 - nums[i];
            curr2 = Integer.MAX_VALUE/4;
            if(curr<0)  curr = 0;
            if(curr2<0)  curr2 = 0;
            return Math.min(curr, curr2);
        }
        else{
            curr = Math.max(nums[i-1], nums[i+1]) + 1 - nums[i];
            curr2 = Math.max(nums[i], nums[i+2]) + 1 - nums[i+1];
        }
        if(curr<0)  curr = 0;
        if(curr2<0)  curr2 = 0;

        int res1 = finder(nums, k, i+1);
        int res2 = curr+ finder(nums, k-1, i+2);
        int res3 = curr2+ finder(nums, k-1, i+3);

        int res = Math.min(res1, res2);
        res = Math.min(res, res3);

        dp[k][i] = res;

        return res;

    }
}