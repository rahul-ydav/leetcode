public class Forth {
    long[][][] dp;
    public long countBalanced(long low, long high) {


        long res1 = finder(high);
        long res2 = finder(low-1);

        return res1-res2;
    }

    long finder(long val){
        if(val<10)  return 1;

        String s = val+"";
        int n = s.length();
        int digit = s.charAt(0) - '0';
        dp = new long[n][200][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<200; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        long res = 0;
        for(int i=0; i<digit; i++){
            res += maker(s, 1, i, false);
        }
        res+=maker(s, 1, digit, true);
        return res;
    }

    long maker(String s, int idx, int sum, boolean tight){
        if(idx==s.length()){
            if(sum==0)  return 1;
            return 0;
        }
        if(tight){
            if(dp[idx][sum+100][1]>=0){
                return dp[idx][sum+100][1];
            }
        }
        else if(dp[idx][sum+100][0]>=0){
            return dp[idx][sum+100][0];
        }
        long res = 0;
        int digit = s.charAt(idx) - '0';
        int start = (tight) ? digit : 9;

        for(int i=start; i>=0; i--){
            tight = tight && i==start;
            if(idx%2!=0){
                res+=maker(s, idx+1, sum-i, tight);
            }
            else{
                res+=maker(s, idx+1, sum+i, tight);
            }
        }



        return dp[idx][sum+100][tight? 1: 0] = res;
    }
}
