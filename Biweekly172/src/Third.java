class Third {
    public long maximumScore(int[] nums, String s) {
        long res = 0;

        int n = nums.length;

        int curr = 0;
        int imax = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                int jMax = i;
                for(int j=curr; j<i; j++){
                    if(nums[j]>nums[jMax]){
                        jMax = j;
                    }
                }
                res+=nums[jMax];
                curr = jMax+1;
            }
        }
        return res;
    }
}