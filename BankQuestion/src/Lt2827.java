import java.util.Arrays;

public class Lt2827 {
    int[][][][][] dp = new int[10][2][21][20][2];
    public int numberOfBeautifulIntegers(int low, int high, int k) {

        String sh = ""+high;
        int len = sh.length();

        for(int[][][][] d1 : dp){
            for(int[][][] d2 : d1){
                for(int[][] d3 : d2){
                    Arrays.fill(d3[0], -1);
                    Arrays.fill(d3[1], -1);
                }
            }
        }
        int res1 = finder(sh, k, 0, 1, 10, 0, 0);

        if(low>0)   low--;
        String sl = ""+low;
        int len2 = sl.length();

        for(int[][][][] d1 : dp){
            for(int[][][] d2 : d1){
                for(int[][] d3 : d2){
                    Arrays.fill(d3[0], -1);
                    Arrays.fill(d3[1], -1);
                }
            }
        }
        int res2 = finder(sl, k, 0, 1, 10, 0, 0);

        return res1-res2;


    }

    int finder(String s, int k, int pos, int tight, int count, int rem, int started){

        if(pos==s.length()){
            if(count==10 && rem==0 && started ==1){
                return 1;
            }
            return 0;
        }

        if(dp[pos][tight][count][rem][started]!=-1)  return dp[pos][tight][count][rem][started];

        int res = 0;
        int max = (tight==1) ? s.charAt(pos) -'0' : 9;

        for(int i=0; i<=max; i++){
            int newCount = ((i&1)==1) ? count-1: count+1;
            int newStart = (i==0 && started==0) ? 0 : 1;
            int newTight = tight;
            int newRem = rem;
            if(newStart==1){
                newTight = (i==max && tight==1) ? 1 : 0;
                newRem = (rem*10 + i)%k;
            }
            res+=finder(s, k, pos+1, newTight, newCount, newRem, newStart);
        }

        return dp[pos][tight][count][rem][started] = res;
    }
}