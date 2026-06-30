class Third {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] pf = new long[n+5];
        long[] sf = new long[n+5];
        long res = 0;
        long res2 = 0;
        for(int i=1; i<n-1; i+=2){
            if(!(nums[i]>nums[i-1] && nums[i]>nums[i+1])){
                res += (long)(Math.max(nums[i-1], nums[i+1])+1 - nums[i]);
                pf[i] = res;
            }
        }
        if(n%2==1){
            return res;
        }

        for(int i=n-2; i>=1; i-=2){
            if(!(nums[i]>nums[i-1] && nums[i]>nums[i+1])){
                res2 += (long)(Math.max(nums[i-1], nums[i+1])+1 - nums[i]);
                sf[i] = res2;
            }
        }
        long ans = sf[2];
        for(int i=1; i<n-1; i+=2){
            ans = Math.min(ans, pf[i] + sf[i+3]);
        }

        return ans;
    }
}