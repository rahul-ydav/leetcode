class Third {

    int[][] memo;
    public int minXor(int[] nums, int k) {
        memo = new int[nums.length+1][k+1];
        return finder(nums, k-1, 0, 0, 0);
    }

    int finder(int[] nums, int k, int i, int currXor, int maxXor){

        if(i==nums.length-1){
            currXor = (currXor^nums[i]);
            maxXor = Math.max(currXor, maxXor);
            if(k>0) return Integer.MAX_VALUE;
            return maxXor;
        }

         if(memo[i][k]!=0){
             return memo[i][k];
         }
        currXor = (currXor^nums[i]);
        int ans = 0;

        if(k>0){
            ans = Math.min(finder(nums, k-1, i+1, 0, Math.max(maxXor, currXor)), finder(nums, k, i+1, currXor, maxXor));
        }
        else{
            ans = finder(nums, k, i+1, currXor, maxXor);
        }

        memo[i][k] = ans;
        return ans;
    }
}