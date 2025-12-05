class Third {
    public int longestPalindrome(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        StringBuilder sb = new StringBuilder(t);
        t = sb.reverse().toString();

        if(s.compareTo(t)==0)  return sn+tn;


        int maxLen = 0;

        int l1 = findMaxPalindrome(s, sn);
        maxLen = Math.max(maxLen, l1);
        int l2 = findMaxPalindrome(t, tn);
        maxLen = Math.max(maxLen, l2);
        this.dp = new int[sn][tn];

        int comLen= findlcs(s, t, sn-1, tn-1);

        maxLen = Math.max(maxLen, comLen);

        return maxLen;
    }

    public int[][] dp;

    int findlcs(String s, String t, int n, int m){
        //base condition
        if(n<0 || m<0)    return 0;

        if(dp[n][m]!=0) return dp[n][m];
        int res = 0;
        //logic
        int i = n;
        int j = m;
        while(i>=0 && j>=0 && s.charAt(i)==t.charAt(j)){
            res+=2;
            i--;
            j--;
        }
//        if(res>0 && (n!=s.length()-1 || m!=t.length()-1)) res++;
        //better logic

        //traversal
        res = Math.max(res, findlcs(s, t, n-1, m));
        res = Math.max(res, findlcs(s, t, n, m-1));
        dp[n][m] = res;
        return res;
    }

    int findMaxPalindrome(String s, int len){
        int MaxRes = 0;
        for(int i=0; i<len; i++){
            int res = 0;
            int k = 1;

            while(i-k>=0 && i+k<len){
                if(s.charAt(i-k)!=s.charAt(i+k))    break;
                res++;
                k++;
            }

            MaxRes = Math.max(MaxRes, res*2+1);
            res = 0;
            if(i+1<len && s.charAt(i)==s.charAt(i+1)){
                k=0;
                while(i-k>=0 && i+1+k<len){
                    if(s.charAt(i-k)!=s.charAt(i+1+k))    break;
                    res++;
                    k++;
                }
            }
            MaxRes = Math.max(MaxRes, res*2);
        }
        return MaxRes;
    }
}