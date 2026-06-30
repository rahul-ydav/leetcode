import java.util.Arrays;

class Lt354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> (a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);

        int[] dp = new int[envelopes.length];

        int len = 0;
        boolean inserted = false;
        for(int i=0; i<envelopes.length; i++){
            if(inserted && envelopes[i][0]==envelopes[i-1][0]) continue;
            inserted = false;
            int[] en = envelopes[i];
            int idx = Arrays.binarySearch(dp, 0, len, en[1]);
            if(idx<0){
                idx = -(idx+1);
            }
            dp[idx] = en[1];
            if(idx==len){
                len++;
                System.out.println(en[1]);
                inserted = true;
            }
            else if(idx==len-1) inserted = true;
        }
        System.out.println(Arrays.toString(dp));
        return len;
    }
}