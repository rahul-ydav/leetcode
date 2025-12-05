class Third {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long mod = 1000000007;
        int n = s.length();

        long[] no0num = new long[n+1];
        long[] ps = new long[n+1];
        int[] cnt = new int[n+1];


        for(int i=0; i<n; i++){
            int digit = s.charAt(i) - '0';
            cnt[i+1] = cnt[i];
            no0num[i+1] = no0num[i];
            ps[i+1] = ps[i]+digit;
            if(digit!=0){
                cnt[i+1]++;
                no0num[i+1] = (no0num[i]*10 + digit);
            }
        }

        int[] answer = new int[queries.length];


        long[] pows = new long[n+1];
        pows[0] = 1;
        for(int i=1; i<n; i++){
            pows[i] = (pows[i-1]*10)%mod;
        }


        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = ps[r+1] - ps[l];
            int len = cnt[r+1] - cnt[l];
            long val = (no0num[r+1] - (no0num[l]*pows[len])%mod + mod)%mod;

            answer[i] = (int)((val*sum)%mod);
        }
        return answer;
    }
}