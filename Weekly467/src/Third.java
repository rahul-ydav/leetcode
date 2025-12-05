import java.util.Arrays;

class Third {
    private int[][] memo;
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {

        int n = nums.length;
        boolean[] res = new boolean[n];
        for(int i=0; i<n; i++){
            int x = i+1;

            int[] cap = new int[n];

            int sum=0;
            for(int j=0; j<n; j++){
                cap[j] = Math.min(x, nums[j]);
                sum+=cap[j];
            }

            memo = new int[n+1][sum+1];

            res[i] = coinChange(cap, k, n);


        }

        return res;
    }

    private boolean coinChange(int[] cap, int target, int n){

        boolean[] vals = new boolean[target+1];

        vals[0] = true;

        for(int i=0; i<n; i++){
            boolean[] vals2 = Arrays.copyOf(vals, target+1);

            System.out.println("vals: "+ Arrays.toString(vals));
            for(int j=0; j<=target; j++){
                if(vals[j] && j+cap[i]<=target){
                    vals2[j+cap[i]] = true;

                }
                if(j+cap[i]==target){
                    System.out.println("i: "+i);
                    return true;
                }
            }
            System.out.println("vals2: "+ Arrays.toString(vals2));
            vals = vals2;
        }
        return false;
    }

    private boolean targetSum(int[] cap, int target, int idx, int sum){

        if(sum==target){
            return true;
        }
        if(idx == cap.length) return false;

        // System.out.println("idx: "+idx+", sum: "+sum);

        if(memo[idx][sum]!=0){
            return memo[idx][sum] == 1;
        }

        boolean res = false;
        res = targetSum(cap, target, idx+1, sum);
        if(!res && cap[idx]+sum<=target){
            boolean ans = targetSum(cap, target, idx+1, sum+cap[idx]);
            if(ans){
                res = ans;
            }
        }

        if(res){
            memo[idx][sum] = 1;
        }
        else memo[idx][sum] = 2;

        return res;

    }
}