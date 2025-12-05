public class Third2 {
    int[][] memo;

    int[] pfx;
    public int minXor(int[] nums, int k) {
        memo = new int[nums.length+1][k+1];

        pfx = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            pfx[i+1] = pfx[i]^nums[i];
        }
        return finder(nums, k-1, 0, -1, 0);
    }

    /*
        k = 3;
        2, 3, 3 2
    * */

    int finder(int[] nums, int k, int i, int li, int maxXor){

        //base condition
        if(i==nums.length-1){
            if(k>0) return Integer.MAX_VALUE;
            return Math.max(maxXor, (pfx[i+1]^pfx[li+1]));
        }

        if(memo[i][k]!=0 && memo[i][k]<=maxXor) return memo[i][k];



        int ans = 0;
        if(k>0){
            int currXor = pfx[i+1]^pfx[li+1];
            ans = Math.min(finder(nums, k-1, i+1, i, Math.max(maxXor, currXor)), finder(nums, k, i+1, li, maxXor));
        }
        else{
            ans = finder(nums, k, i+1, li, maxXor);
        }

        memo[i][k] = ans;
        return ans;
    }
}
