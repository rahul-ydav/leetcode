class Forth {
    int n;
    public long minPartitionScore(int[] nums, int k) {
        n = nums.length;
        long res = finder(nums, k, 0, 0);

        return res;
    }



    long finder(int[] nums, int k, int idx, int sumArr){
        sumArr = sumArr + nums[idx];
        if(n-idx==k){
            long currVal = sumArr*((sumArr+1)/2L);

            for(int i=idx+1; i<n; i++){
                currVal += nums[i]*((nums[i]+1)/2L);
            }
            return currVal;
        }

        long valSum = Integer.MAX_VALUE;

        if(k>1){
            long currVal = ((long)sumArr*(sumArr+1))/2L;
            valSum = Math.min(currVal + finder(nums, k-1, idx+1, 0), finder(nums, k, idx+1, sumArr));
        }
        else{
            for(int i=idx+1; i<n; i++){
                sumArr+=nums[i];
            }
            valSum =((long)sumArr*(sumArr+1))/2;
        }

        return valSum;
    }
}