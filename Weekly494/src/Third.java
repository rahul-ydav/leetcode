import java.util.Arrays;

class Third {

    int[][] dp;
    // Hash
    public int minRemovals(int[] nums, int target) {



        int mx = 0;
        for(int val : nums){
            mx = Math.max(mx, val);
        }
        int power = 1;
        while (power <= target) {
            power <<= 1;
        }

        dp = new int[power][nums.length+5];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        int res = finder(nums, target, 0);
        if(res>40) return -1;
        return res;
    }

    int finder(int[] nums, int t, int i){

        if(i==nums.length){
            if(t==0) return 0;
            return Integer.MAX_VALUE/4;
        }
        if(dp[t][i]!=-1) return dp[t][i];
        int res1 = finder(nums, (t^nums[i]), i+1);
        int res2 = 1 + finder(nums, t, i+1);

        int res = Math.min(res1, res2);
        dp[t][i] = res;
        return res;

    }
}