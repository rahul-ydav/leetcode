import java.util.Arrays;

public class Lt3753 {
    long[][][][][] dp = new long[2][12][12][17][17];
    public long totalWaviness(long num1, long num2) {

        if(num2<100)    return 0;
        for(long[][][][] d1 : dp){
            for(long[][][] d2 : d1){
                for(long[][] d3 : d2){
                    for(long[] d4 : d3){
                        Arrays.fill(d4, -1);
                    }
                }
            }
        }
        String s = ""+num2;
        long res1 = finder(s, 0, 1, 10, 10, 0);
        num1--;
        s = ""+num1;
        if(num1<100)    return res1;
        for(long[][][][] d1 : dp){
            for(long[][][] d2 : d1){
                for(long[][] d3 : d2){
                    for(long[] d4 : d3){
                        Arrays.fill(d4, -1);
                    }
                }
            }
        }
        long res2 = finder(s, 0, 1, 10, 10, 0);

        return res1-res2;
    }

    long finder(String s, int idx, int tight, int pp, int prev, int start){

        if(idx==s.length() || start+2==s.length()){
            return 0;
        }

        if(dp[tight][pp][prev][idx][start]!=-1)  return dp[tight][pp][prev][idx][start];

        int limit = (tight==1) ? s.charAt(idx)-'0' : 9;
        long res = 0;
        for(int i=0; i<=limit; i++){
            int newTight = (tight==1 && i==limit) ? 1 : 0;
            int newStart = (i==0 && start==idx) ? start+1 : start;
            long add = 0L;
            if((pp<prev && prev>i) || (pp>prev && prev<i)){
                long num = Long.parseLong(s);
                int shift = s.length()-idx;
                long val = (1<<shift);
                add = num-val;
            }

            res+=add + finder(s, idx+1, newTight, prev, i, newStart);
        }

        return dp[tight][pp][prev][idx][start] = res;
    }
}