class Third {
    String s;
    String t;
    int[][][] dp;
    public boolean canMakeSubsequence(String s, String t) {
        this.s = s;
        this.t = t;
        dp = new int[s.length()+1][t.length()+1][2];
        for(int[][] d1 : dp){
            for(int[] d2 : d1){
                d2[0] = -1;
                d2[1] = -1;
            }
        }
        int res = finder(0, 0, 0);
        if(res>0)   return true;

        for(int[][] d1 : dp){
            for(int[] d2 : d1){
                d2[0] = -1;
                d2[1] = -1;
            }
        }
        res = finder(1, 1, 1);

        return res>0;

    }

    int finder(int i1, int i2, int excluded){

        if(i1>=s.length())  return 1;
        if(i2>=t.length())  return 0;
        if(dp[i1][i2][excluded]!=-1)    return dp[i1][i2][excluded];
        int res = 0;
        if(s.charAt(i1)==t.charAt(i2)){
            if(excluded==0){
                res = finder(i1+1, i2+1, 0) +  finder(i1+2, i2+2, 1);
            }
            else{
                res = finder(i1+1, i2+1, excluded);
            }
        }
        else{
            res = finder(i1, i2+1, excluded);
        }

        return dp[i1][i2][excluded] = res;
    }
}